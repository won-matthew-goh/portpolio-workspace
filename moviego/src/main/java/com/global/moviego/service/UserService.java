package com.global.moviego.service;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.EmailChangeException;
import com.global.moviego.exception.PasswordChangeException;

import java.util.List;

public interface UserService {
    List<UserVO> getAllUsers();
    UserVO getUserByUsername(String username);
    void insertUser(UserVO user);
//    void updateUser(UserVO user);
    void deleteUser(Long userId);
    void updateEmail(Long userId, String email);
    void resetPassword(Long userId);
    void changePassword(String username, String currentPassword, String newPassword) throws PasswordChangeException;
    void changeEmail(String username, String newEmail) throws EmailChangeException;
}
