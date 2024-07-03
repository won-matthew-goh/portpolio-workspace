package com.global.moviego.service;

import java.util.List;

import com.global.moviego.domain.ReviewBoardVO;

public interface ReviewBoardService {

  //글 조회 메소드
  public List<ReviewBoardVO> selectReviewService();
  
  //글 저장 메소드
  public void register(ReviewBoardVO vo);
  
//  //글 조회수 메소드
//  public int selectReviewCnt();
//  //게시글 수정 메소드(Update)
//  public List<ReviewBoardVO> updateReview();
//  
//  //게시글 삭제 메소드(Delete)
//  public List<ReviewBoardVO> deleteReview();
}
