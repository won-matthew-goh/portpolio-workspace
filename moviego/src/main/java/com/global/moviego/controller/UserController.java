package com.global.moviego.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.DuplicateException;
import com.global.moviego.exception.EmailChangeException;
import com.global.moviego.exception.PasswordChangeException;
import com.global.moviego.service.JoinService;
import com.global.moviego.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private JoinService joinService;
  
  @Autowired
  private UserService userService;

  @Autowired
  private MessageSource messageSource;

  @GetMapping("/join")
  public String forwardJoin(Model model, Locale locale) {
    model.addAttribute("userVO", new UserVO());
    return "user/join";
  }

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
      System.out.println(e.getMessage());
      String errorMessage = "";
      if(e.getMessage().contains("username") || e.getMessage().contains("ユーザー名")) {
        errorMessage = messageSource.getMessage("error.duplicate.username", new Object[] { userVO.getUsername() },
            locale);
      }
      if(e.getMessage().contains("email") || e.getMessage().contains("メール")) {
        errorMessage = messageSource.getMessage("error.duplicate.email", new Object[] { userVO.getUsername() },
            locale);
      }
      model.addAttribute("error", errorMessage);
      return "user/join";
    }
  }
  
  @GetMapping("/mypage")
  public String myPage() {
    return "user/mypage";
  }
  
//  @PostMapping("/changePassword")
//  public String changePassword(@RequestParam("currentPassword") String currentPassword,
//                               @RequestParam("newPassword") String newPassword,
//                               @RequestParam("newPasswordConfirm") String newPasswordConfirm,
//                               Model model, Principal principal, Locale locale) {
//
//      // Validate input
//      if (!newPassword.equals(newPasswordConfirm)) {
//          model.addAttribute("error", "Passwords do not match");
//          return "redirect:/mypage"; // Redirect to mypage with error message
//      }
//
//      try {
//          userService.changePassword(principal.getName(), currentPassword, newPassword);
//          model.addAttribute("successMessage", "Password changed successfully");
//      } catch (PasswordChangeException e) {
//          model.addAttribute("error", e.getMessage());
//      }
//
//      return "redirect:/mypage";
//  }
//
//  @PostMapping("/changeEmail")
//  public String changeEmail(@RequestParam("newEmail") String newEmail,
//                            Model model, Principal principal, Locale locale) {
//
//      try {
//          userService.changeEmail(principal.getName(), newEmail);
//          model.addAttribute("successMessage", "Email changed successfully");
//      } catch (EmailChangeException e) {
//          model.addAttribute("error", e.getMessage());
//      }
//
//      return "redirect:/mypage";
//  }

}
