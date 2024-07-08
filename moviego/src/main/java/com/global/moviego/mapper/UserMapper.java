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
  
  int checkUsernameExists(String username);
  
  int checkEmailExists(String email);
  
  void insertMemberJoin(UserVO user);
  
  UserVO findByUsername(String username);

  //@Select("SELECT * FROM users")
  List<UserVO> getAllUsers();

 // @Delete("DELETE FROM users WHERE userId = #{userId}")
  void deleteUser(Long userId);
}
