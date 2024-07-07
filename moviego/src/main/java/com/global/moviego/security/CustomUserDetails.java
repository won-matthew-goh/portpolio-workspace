package com.global.moviego.security;

import com.global.moviego.domain.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Spring Security에서 사용자 정보를 표현하는 클래스
 * UserVO를 래핑하여 UserDetails 인터페이스를 구현합니다.
 */
public class CustomUserDetails implements UserDetails {
    private final UserVO user;

    public CustomUserDetails(UserVO user) {
        this.user = user;
    }

    /**
     * 사용자의 권한 목록을 반환합니다.
     * 여기서는 사용자의 grade를 기반으로 단일 권한을 생성합니다.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.user.getGrade().name()));
    }

    @Override
    public String getPassword() {
        return this.user.getPasswd();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    /**
     * 계정 만료 여부를 반환합니다.
     * 현재 구현에서는 항상 true를 반환하여 만료되지 않음을 나타냅니다.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 계정 잠금 여부를 반환합니다.
     * 현재 구현에서는 항상 true를 반환하여 잠기지 않음을 나타냅니다.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 자격 증명(비밀번호) 만료 여부를 반환합니다.
     * 현재 구현에서는 항상 true를 반환하여 만료되지 않음을 나타냅니다.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 계정 활성화 여부를 반환합니다.
     * deletedAt 필드가 null이면 활성화된 것으로 간주합니다.
     */
    @Override
    public boolean isEnabled() {
        return this.user.getDeletedAt() == null;
    }

    /**
     * 원본 UserVO 객체를 반환합니다.
     */
    public UserVO getUser() {
        return user;
    }
}