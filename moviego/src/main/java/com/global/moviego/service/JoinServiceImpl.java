package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.DuplicateException;
import com.global.moviego.mapper.UserMapper;

@Service
public class JoinServiceImpl implements JoinService {
  
  @Autowired
  private UserMapper userMapper;
  
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  public void joinProcess(UserVO user) {
      // username 중복 체크
      int count = userMapper.checkUsernameExists(user.getUsername());
      if (count > 0) {
          throw new DuplicateException("이미 사용 중인 username입니다: " + user.getUsername());
      }
      
      // Email 중복 체크
      if (userMapper.checkEmailExists(user.getEmail()) > 0) {
          throw new DuplicateException("이미 사용한 적이 있는 email 주소입니다.");
      }

      // 비밀번호 암호화
      user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));

      // 회원 가입
      userMapper.insertMemberJoin(user);
  }

}
