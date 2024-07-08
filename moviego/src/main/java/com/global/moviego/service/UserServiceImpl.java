package com.global.moviego.service;

import com.global.moviego.domain.UserVO;
import com.global.moviego.exception.EmailChangeException;
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
    
//    @Override
//    public void changePassword(Long userId, String currentPassword, String newPassword) {
//        UserVO user = userMapper.getUserById(userId);
//        if (user != null && user.getPasswd().equals(currentPassword)) {
//            userMapper.updatePassword(userId, newPassword);
//        } else {
//            throw new IllegalArgumentException("Invalid current password");
//        }
//    }
//
//    @Override
//    public void changeEmail(Long userId, String newEmail) throws EmailChangeException {
//        // 사용자 아이디로 사용자를 조회하여 기존 이메일과 새 이메일을 비교하고 처리합니다.
//        UserVO user = userMapper.getUserById(userId);
//        if (user == null) {
//            throw new EmailChangeException("User not found for id: " + userId);
//        }
//
//        // 기존 이메일과 새 이메일이 동일하면 변경할 필요가 없습니다.
//        if (user.getEmail().equals(newEmail)) {
//            throw new EmailChangeException("New email must be different from the current one.");
//        }
//
//        // 이메일 업데이트 처리
//        int updatedRows = userMapper.updateEmail(userId, newEmail);
//        if (updatedRows != 1) {
//            throw new EmailChangeException("Failed to update email for user id: " + userId);
//        }
//    }

}
