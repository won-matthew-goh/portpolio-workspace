package com.global.moviego.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.UserGrade;
import com.global.moviego.domain.UserVO;
import com.global.moviego.mapper.UserMapper;
import com.global.moviego.security.CustomUserDetails;

/**
 * Spring Security에서 사용자 정보를 로드하는 서비스
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), 
            user.getPasswd(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getGrade().name()))
        );
    }
}