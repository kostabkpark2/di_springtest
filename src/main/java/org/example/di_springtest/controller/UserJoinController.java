package org.example.di_springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.model.User;
import org.example.di_springtest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserJoinController {
  private final UserService userService;

  @GetMapping("/join")
  public String userJoin() {
    return "userJoin";
  }

  @PostMapping("/join")
  public String userLogin(User user) {
    userService.createNewUser(user);
    return "redirect:/users/login";
  }
}
