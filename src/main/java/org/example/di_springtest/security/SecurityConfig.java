package org.example.di_springtest.security;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
  private final UserService userService;

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
          .requestMatchers("/users/login", "/users/join", "/users/check").permitAll()
          .anyRequest().authenticated());
    http.formLogin(form-> form
          .loginPage("/users/login")
        .usernameParameter("userId")
        .passwordParameter("password")
        .loginProcessingUrl("/users/login")
        .successHandler(new LoginSuccessHandler())
        .failureHandler(new LoginFailureHandler()));

    http.logout(logout -> logout
          .logoutUrl("/logout")
          .logoutSuccessUrl("/users/login"));
//    http.userDetailsService(userService);
    return http.build();
  }
}
