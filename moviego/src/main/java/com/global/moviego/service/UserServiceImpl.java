package com.global.moviego.service;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.EmailChangeException;
import com.global.moviego.exception.PasswordChangeException;
import com.global.moviego.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
      this.userMapper = userMapper;
      this.passwordEncoder = passwordEncoder;
  }

  @Override
  public List<UserVO> getAllUsers() {
    return userMapper.getAllUsers();
  }

  @Override
  public UserVO getUserByUsername(String username) {
    return userMapper.findByUsername(username);
  }

  @Override
  public void insertUser(UserVO user) {
    userMapper.insertMemberJoin(user);
  }

//    @Override
//    public void updateUser(UserVO user) {
//        userMapper.updateUser(user);
//    }

  @Override
  public void deleteUser(Long userId) {
    userMapper.deleteUser(userId);
  }

  @Override
  public void updateEmail(Long userId, String email) {
    userMapper.updateEmail(userId, email);
  }

  @Override
  public void resetPassword(Long userId) {
    String tempPassword = generateTempPassword();
    userMapper.updatePassword(userId, tempPassword);
  }

  private String generateTempPassword() {
    // 임시 비밀번호 생성 로직 (예: 8자리 랜덤 문자열)
    return UUID.randomUUID().toString().substring(0, 8);
  }

  @Override
  public void changePassword(String username, String currentPassword, String newPassword) throws PasswordChangeException {
      UserVO user = userMapper.findByUsername(username);
      if (user == null || !passwordEncoder.matches(currentPassword, user.getPasswd())) {
          throw new PasswordChangeException("password.current.invalid");
      }
      
      // 비밀번호 형식 검증 로직 추가
      if (!isValidPassword(newPassword)) {
          throw new PasswordChangeException("password.new.invalid");
      }
      
      userMapper.updatePassword(user.getUserId(), passwordEncoder.encode(newPassword));
  }

  private boolean isValidPassword(String password) {
      String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&+=/]).{8,12}$";
      return password.matches(regex);
  }

  @Override
  public void changeEmail(String username, String newEmail) throws EmailChangeException {
      UserVO user = userMapper.findByUsername(username);
      if (user == null) {
          throw new EmailChangeException("User not found");
      }
      if (user.getEmail().equals(newEmail)) {
          throw new EmailChangeException("New email must be different from the current one");
      }
      try {
          userMapper.updateEmail(user.getUserId(), newEmail);
      } catch (DataIntegrityViolationException e) {
          throw new EmailChangeException("Email already in use");
      }
  }

}
