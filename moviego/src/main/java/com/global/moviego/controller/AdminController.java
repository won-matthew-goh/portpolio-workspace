package com.global.moviego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.domain.UserVO;
import com.global.moviego.service.ReviewBoardService;
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
  
  @Autowired
  private ReviewBoardService reviewService;

  @GetMapping("")
  public String adminList(Model model) {
    List<UserVO> users = userService.getAllUsers();
    List<ReviewBoardVO> reportedReviews = reviewService.getReportedReviews();
    model.addAttribute("reportedReviews", reportedReviews);
    model.addAttribute("users", users);
    return "user/admin";
  }

//    @DeleteMapping("/deleteUser")
//    @ResponseBody
  @PostMapping("/deleteUser")
  public String deleteUser(@RequestParam("userId") Long userId) {
    userService.deleteUser(userId);
    return "redirect:/admin";
  }

  @PostMapping("/updateUser")
  public String updateUser(@RequestParam("userId") Long userId, @RequestParam("email") String email) {
    userService.updateEmail(userId, email);
    return "redirect:/admin"; // 수정 후 사용자 목록 페이지로 리다이렉트
  }

  @PostMapping("/resetPassword")
  public String resetPassword(@RequestParam("userId") Long userId) {
    userService.resetPassword(userId);
    return "redirect:/admin"; // 임시 비밀번호 발급 후 사용자 목록 페이지로 리다이렉트
  }

  @GetMapping("/reportedReviews")
  public String getReportedReviews(Model model) {
      List<ReviewBoardVO> reportedReviews = reviewService.getReportedReviews();
      System.out.println(reportedReviews);
      model.addAttribute("reportedReviews", reportedReviews);
      return "user/admin"; // 이 경로가 JSP 파일의 위치와 일치해야 합니다.
  }

  @GetMapping("/deleteReview")
  public String deleteReview(@RequestParam("reviewId") int reviewId) {
      reviewService.deleteReview(reviewId);
      return "redirect:/admin";
  }
}
