package com.global.moviego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {
  
  int checkUsernameExists( String username);
  
  int checkEmailExists(String email);
  
  void insertMemberJoin(UserVO user);
  
}
