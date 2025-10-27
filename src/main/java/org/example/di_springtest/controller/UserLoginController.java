package org.example.di_springtest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.di_springtest.model.User;
import org.example.di_springtest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
  public String userJoin(User user) {
    User findUser = userService.getUserByUserId(user.getUserId());
    if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
      log.info(" 로그인시 입력한 암호 - {}, DB 에 들어있는 암호 - {}", user.getPassword(), findUser.getPassword());
      return "redirect:/posts/list";
    }
    return "redirect:/users/login";
  }
}
