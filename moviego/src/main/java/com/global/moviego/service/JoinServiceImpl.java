package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.DuplicateException;
import com.global.moviego.mapper.UserMapper;

@Service
public class JoinServiceImpl implements JoinService {
  
  @Autowired
  private UserMapper userMapper;
  
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Autowired
  private MessageSource messageSource;
  
  @Override
  @Transactional
  public void joinProcess(UserVO user) {
      // Username 중복 체크
      if (userMapper.checkUsernameExists(user.getUsername()) > 0) {
          throw new DuplicateException(messageSource.getMessage("error.duplicate.username", 
              new Object[]{user.getUsername()}, LocaleContextHolder.getLocale()));
      }

      // Email 중복 체크
      if (userMapper.checkEmailExists(user.getEmail()) > 0) {
          throw new DuplicateException(messageSource.getMessage("error.duplicate.email", 
              null, LocaleContextHolder.getLocale()));
      }

      // 비밀번호 암호화 및 사용자 추가
      user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
      userMapper.insertMemberJoin(user);
  }
}

