package com.global.moviego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.domain.LoginVO;

import java.util.Locale;

@Controller
public class LoginController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping("/login")
  public String loginForm(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout, Model model, Locale locale) {
    System.out.println("LoginController.loginForm() called");
    if (error != null) {
      String errorMsg = messageSource.getMessage("login.error", null, "Invalid username or password", locale);
      model.addAttribute("error", errorMsg);
    }
    if (logout != null) {
      model.addAttribute("message", messageSource.getMessage("logout.success", null, locale));
    }
    return "user/login";
  }

  @GetMapping("/mypage")
  public String myPage() {
    return "user/mypage";
  }
}