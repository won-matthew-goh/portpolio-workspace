package com.global.moviego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {
  
  // 회원 가입 시 username 중복 체크
  int checkUsernameExists(String username);
  
  // email 중복 체크
  int checkEmailExists(String email);
  
  // 회원 가입
  void insertMemberJoin(UserVO user);
  
  // 사용자 조회
  UserVO findByUsername(String username);
  
  // 관리자 페이지에서 모든 사용자 조회
  List<UserVO> getAllUsers();
  
//  void updateUser(UserVO user);
  
  // 사용자 삭제
  void deleteUser(Long userId);
  
  // email 수정
  void updateEmail(@Param("userId") Long userId, @Param("email") String email);
  
  // 비밀번호 초기화 및 재발급
  void updatePassword(@Param("userId") Long userId, @Param("password") String password);
  
  UserVO getUserById(Long userId);

  String getPassword(Long userId);
}
