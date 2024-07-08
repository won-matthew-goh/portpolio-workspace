package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
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

    /**
     * 주어진 username으로 사용자 정보를 로드합니다.
     * @param username 사용자 이름
     * @return UserDetails 객체
     * @throws UsernameNotFoundException 사용자를 찾을 수 없을 때 발생
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username이 존재하지 않습니다. :  " + username);
        }
        return new CustomUserDetails(user);
    }
}