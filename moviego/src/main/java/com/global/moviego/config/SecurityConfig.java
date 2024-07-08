package com.global.moviego.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.global.moviego.service.CustomUserDetailsService;

/**
 * Spring Security 설정 클래스
 * 애플리케이션의 보안 설정을 정의합니다.
 */
@Configuration // 이 클래스가 스프링의 설정 클래스임을 나타냅니다.
@EnableWebSecurity // 웹 보안 기능을 활성화합니다.
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService; // 사용자 정의 UserDetailsService를 주입받습니다.

    /**
     * 비밀번호 암호화를 위한 BCryptPasswordEncoder 빈을 생성합니다.
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * AuthenticationManager 빈을 생성합니다. 인증 처리를 담당합니다.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Spring Security 필터 체인을 구성합니다.
     * @param httpSecurity HttpSecurity 객체
     * @return 구성된 SecurityFilterChain
     * @throws Exception 보안 구성 중 발생할 수 있는 예외
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // URL 기반의 접근 권한 설정
        httpSecurity
            .authorizeHttpRequests((auth) -> auth
                // 모든 사용자가 접근 가능한 경로 설정
                .requestMatchers( "/**", "/movieList/**", "/boxoffice", "/user/**").permitAll()
                // ADMIN 역할을 가진 사용자만 접근 가능한 경로 설정
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // ADMIN 또는 USER 역할을 가진 사용자만 접근 가능한 경로 설정
                .requestMatchers("/mypage").hasAnyRole("ADMIN", "USER")
                // 그 외 모든 요청은 인증된 사용자만 접근 가능
                .anyRequest().authenticated()
            );

        // 폼 로그인 설정
        httpSecurity
            .formLogin((auth) -> auth
                .loginPage("/login") // 커스텀 로그인 페이지 경로 설정
                .loginProcessingUrl("/login") // 로그인 처리 URL 설정
                .defaultSuccessUrl("/") // 로그인 성공 시 리다이렉트 경로
                .failureUrl("/login?error") // 로그인 실패 시 리다이렉트 경로
                .permitAll()
            )
            // 로그아웃 설정
            .logout(logout -> logout
                .logoutUrl("/logout") // 로그아웃 처리 URL
                .logoutSuccessUrl("/") // 로그아웃 성공 시 리다이렉트 경로
                .invalidateHttpSession(true) // 세션 무효화
                .deleteCookies("JSESSIONID") // 쿠키 삭제
            )
            .userDetailsService(userDetailsService); // 사용자 정의 UserDetailsService 설정

        // CSRF 보호 기능 비활성화
        // 주의: 실제 운영 환경에서는 CSRF 보호를 활성화하는 것이 좋습니다.
        httpSecurity
            .csrf((auth) -> auth.disable());

        return httpSecurity.build();
    }
}