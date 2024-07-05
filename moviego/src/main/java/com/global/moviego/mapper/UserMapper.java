package com.global.moviego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {
  
  int checkUsernameExists(@Param("username") String username);
  
  void insertMemberJoin(UserVO user);
  
}
