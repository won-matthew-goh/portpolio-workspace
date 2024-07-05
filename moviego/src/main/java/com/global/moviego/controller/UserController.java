package com.global.moviego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.moviego.domain.UserVO;
import com.global.moviego.service.JoinService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private JoinService joinService;

  @GetMapping("/login")
  public String fowardLogin() {

    return "user/login";
  }

  @GetMapping("/join")
  public String fowardJoin() {

    return "user/join";
  }

  @PostMapping("/joinProc")
  public String joinProc(@RequestBody UserVO userVO) {

    System.out.println(userVO.getUsername());

    joinService.joinProcess(userVO);

    return "redirct: /user/login";
  }

}
