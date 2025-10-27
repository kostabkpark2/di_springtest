package org.example.di_springtest.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.di_springtest.model.User;
import org.example.di_springtest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserLoginController {
  private final UserService userService;

  @GetMapping("/login")
  public String userJoin() {
    return "userLogin";
  }

  @PostMapping("/login")
  public String userJoin(User user, HttpSession session) {
    User findUser = userService.getUserByUserId(user.getUserId());
    if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
      session.setAttribute("user", findUser);
      return "redirect:/posts/list";
    }
    return "redirect:/users/login";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
    session.invalidate();
    return "redirect:/users/login";
  }
}
