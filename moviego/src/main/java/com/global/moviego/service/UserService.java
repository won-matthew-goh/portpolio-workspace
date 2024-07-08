package com.global.moviego.service;

import com.global.moviego.domain.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> getAllUsers();
    UserVO getUserByUsername(String username);
    void insertUser(UserVO user);
//    void updateUser(UserVO user);
    void deleteUser(Long userId);
    void updateEmail(Long userId, String email);
    void resetPassword(Long userId);
}
