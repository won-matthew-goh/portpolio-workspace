package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.UserVO;
import com.global.moviego.mapper.UserMapper;

import java.util.List;

	@Service
	public class UserServiceImpl {

	    @Autowired
	    private UserMapper userMapper;

	    public List<UserVO> getAllUsers() {
	        return userMapper.getAllUsers();
	    }

	    public void deleteUser(Long userId) {
	        userMapper.deleteUser(userId);
	    }
	}

