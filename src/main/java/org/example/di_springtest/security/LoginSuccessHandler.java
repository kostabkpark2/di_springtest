package org.example.di_springtest.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.di_springtest.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Authentication authentication)
                                      throws IOException, ServletException {
    log.info("login success handler");

    HttpSession session = request.getSession(true);// 세션이 없으면 새로 생성해서 반환
    User user = (User) authentication.getPrincipal();
    session.setAttribute("userid", user.getUserId());

    response.sendRedirect("/posts/list");
  }
}
