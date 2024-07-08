package com.global.moviego.service;

import com.global.moviego.domain.UserVO;
import com.global.moviego.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
}
