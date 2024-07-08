package com.global.moviego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import com.global.moviego.domain.LoginVO;

/**
 * 로그인 관련 요청을 처리하는 컨트롤러
 */
@Controller
public class LoginController {

    /**
     * 로그인 페이지를 표시합니다.
     * @param model Spring MVC 모델
     * @return 로그인 페이지의 뷰 이름
     */
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginVO", new LoginVO());
        return "user/login";
    }

    /**
     * 로그인 폼 제출을 처리합니다.
     * 실제 인증은 Spring Security에 의해 처리되므로, 이 메서드는 폼 검증에만 사용됩니다.
     * @param loginVO 로그인 폼 데이터
     * @param bindingResult 검증 결과
     * @return 리다이렉트 경로 또는 로그인 페이지
     */
    @PostMapping("/login")
    public String loginSubmit(@Valid @ModelAttribute LoginVO loginVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        // 실제 인증 처리는 Spring Security에 의해 수행됩니다.
        return "redirect: /";
    }
}