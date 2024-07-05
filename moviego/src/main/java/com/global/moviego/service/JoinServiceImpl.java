package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.UserGrade;
import com.global.moviego.domain.UserVO;
import com.global.moviego.mapper.UserMapper;

@Service
public class JoinServiceImpl implements JoinService {
  
  @Autowired
  private UserMapper userMapper;
  
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  public void joinProcess(UserVO user) {
    user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
//    user.setGrade(UserGrade.REGULAR); // 기본값으로 일반 회원 설정
    userMapper.insertMemberJoin(user);
  }

}
