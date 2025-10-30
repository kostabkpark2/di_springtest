package org.example.di_springtest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.di_springtest.model.User;
import org.example.di_springtest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserJoinController {
  private final UserService userService;

  @GetMapping("/join")
  public String userJoin() {
    log.info("join controller - get method");
    return "userJoin";
  }

  @PostMapping("/join")
  public String userLogin(User user) {
    log.info("join controller - post method");
    log.info("user info : {} ,{} ", user.getUserId(), user.getPassword());
    userService.createNewUser(user);
    return "redirect:/users/login";
  }
}
