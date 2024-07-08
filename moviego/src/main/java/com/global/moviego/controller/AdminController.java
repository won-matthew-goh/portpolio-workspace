package com.global.moviego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.domain.UserVO;
import com.global.moviego.service.ReviewBoardServiceImpl;
import com.global.moviego.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ReviewBoardServiceImpl reviewBoardService;

    @GetMapping("")
    public String adminList(Model model) {
        List<UserVO> userList = userService.getAllUsers();
        List<ReviewBoardVO> reviewList = reviewBoardService.getAllReviews();
        model.addAttribute("userInfo", userList);
        model.addAttribute("reviewInfo", reviewList);
        return "user/admin";
    }

    @DeleteMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
    }

    @DeleteMapping("/deleteReview")
    @ResponseBody
    public void deleteReview(@RequestParam int reviewId) {
        reviewBoardService.deleteReview(reviewId);
    }
}
