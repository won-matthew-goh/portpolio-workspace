package com.global.moviego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.DuplicateException;
import com.global.moviego.service.JoinService;

import org.springframework.web.bind.annotation.PostMapping;

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
  public String fowardJoin(Model model) {
    model.addAttribute("userVO", new UserVO());
    return "user/join";
  }

  @PostMapping("/joinProc")
  public String joinProc(@ModelAttribute("userVO") UserVO userVO, Model model) {
    try {
      joinService.joinProcess(userVO);
      return "user/joinSuccess";
    } catch (DuplicateException e) {
      System.out.println(e.getMessage());
      model.addAttribute("error", e.getMessage());
      return "user/join";
    }
  }

}
