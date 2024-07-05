package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.moviego.domain.UserGrade;
import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.DuplicateUsernameException;
import com.global.moviego.mapper.UserMapper;

@Service
public class JoinServiceImpl implements JoinService {
  
  @Autowired
  private UserMapper userMapper;
  
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  // 중복 처리 전 joinProcess
//  public void joinProcess(UserVO user) {
//    
//    user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
//    userMapper.insertMemberJoin(user);
//  }
  
  @Transactional
  public void joinProcess(UserVO user) {
      // username 중복 체크
      int count = userMapper.checkUsernameExists(user.getUsername());
      if (count > 0) {
          throw new DuplicateUsernameException("이미 사용 중인 username입니다: " + user.getUsername());
      }

      // 비밀번호 암호화
      user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));

      // 회원 가입
      userMapper.insertMemberJoin(user);
  }

}
