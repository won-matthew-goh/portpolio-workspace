package com.global.moviego.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    
    httpSecurity
            .authorizeHttpRequests((auth) -> auth
                                             .requestMatchers( "/**", "/movieList/**", "/boxoffice").permitAll()
                                             .requestMatchers("/admin").hasRole("ADMIN")
                                             .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                                             .anyRequest().authenticated()
                                        );
    
    return httpSecurity.build();
  }
  
}
