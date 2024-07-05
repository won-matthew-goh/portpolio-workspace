package com.global.moviego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {
  
  void insertMemberJoin(UserVO user);
  
}
