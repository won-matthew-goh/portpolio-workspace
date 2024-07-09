package com.global.moviego.controller;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.EmailChangeException;
import com.global.moviego.exception.PasswordChangeException;
import com.global.moviego.service.UserService;

import jakarta.validation.constraints.Email;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String myPage(Authentication authentication, Model model) {
        String username = authentication.getName();
        UserVO user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "user/mypage";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("newPasswordConfirm") String newPasswordConfirm,
                                 Authentication authentication,
                                 RedirectAttributes redirectAttributes,
                                 Locale locale) {
        try {
            if (!newPassword.equals(newPasswordConfirm)) {
                throw new PasswordChangeException("password.mismatch");
            }
            userService.changePassword(authentication.getName(), currentPassword, newPassword);
            redirectAttributes.addFlashAttribute("message", messageSource.getMessage("password.change.success", null, locale));
        } catch (PasswordChangeException e) {
            redirectAttributes.addFlashAttribute("error", messageSource.getMessage(e.getMessage(), null, locale));
        }
        return "redirect:/mypage";
    }

    @PostMapping("/changeEmail")
    public String changeEmail(@RequestParam("newEmail") String newEmail,
                              Authentication authentication,
                              RedirectAttributes redirectAttributes,
                              Locale locale) {
        try {
            userService.changeEmail(authentication.getName(), newEmail);
            redirectAttributes.addFlashAttribute("message", messageSource.getMessage("email.change.success", null, locale));
        } catch (EmailChangeException e) {
            redirectAttributes.addFlashAttribute("error", messageSource.getMessage(e.getMessage(), null, locale));
        }
        return "redirect:/mypage";
    }
}