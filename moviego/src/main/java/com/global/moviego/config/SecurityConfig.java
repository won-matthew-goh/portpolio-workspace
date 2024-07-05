package com.global.moviego.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    
    httpSecurity
            .authorizeHttpRequests((auth) -> auth
                                             .requestMatchers( "/**", "/movieList/**", "/boxoffice", "/member/**").permitAll()
                                             .requestMatchers("/admin").hasRole("ADMIN")
                                             .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                                             .anyRequest().authenticated()
                                        );
    
    httpSecurity
          .formLogin((auth) -> auth.loginPage("/member/login")
                                    .loginProcessingUrl("/")
                                    .permitAll()
                                    );
    
    httpSecurity
          .csrf((auth) -> auth.disable());
    
    return httpSecurity.build();
  }
  
}