package com.global.moviego.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.DuplicateException;
import com.global.moviego.service.JoinService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private JoinService joinService;

  @Autowired
  private MessageSource messageSource;

  @GetMapping("/join")
  public String forwardJoin(Model model, Locale locale) {
    model.addAttribute("userVO", new UserVO());
    return "user/join";
  }

//  @PostMapping("/joinProc")
//  public String joinProc(@ModelAttribute @Valid UserVO userVO, BindingResult bindingResult, Model model, Locale locale) {
//      if (bindingResult.hasErrors()) {
//          System.out.println(bindingResult.getFieldError());
//          model.addAttribute("errors", bindingResult.getAllErrors());
//          return "user/join";
//      }
//      try {
//          joinService.joinProcess(userVO);
//          return "user/joinSuccess";
//      } catch (DuplicateException e) {
//          System.out.println(e.getMessage());
//          model.addAttribute("error", messageSource.getMessage(e.getMessage(), null, locale));
//          return "user/join";
//      }
//  }

  @PostMapping("/joinProc")
  public String joinProc(@ModelAttribute @Valid UserVO userVO, BindingResult bindingResult, Model model,
      Locale locale) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("errors", bindingResult.getAllErrors());
      return "user/join";
    }

    try {
      joinService.joinProcess(userVO);
      return "user/joinSuccess";
    } catch (DuplicateException e) {
      // 예외 메시지 코드를 가져와서 메시지 소스에서 가져오기
      String errorMessage = messageSource.getMessage("error.duplicate.username", new Object[] { userVO.getUsername() },
          locale);
      model.addAttribute("error", errorMessage);
      return "user/join";
    }
  }

}
