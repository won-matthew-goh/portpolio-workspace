package com.global.moviego.service;

import java.util.ArrayList;
import java.util.List;

import com.global.moviego.domain.ReviewBoardVO;

public interface ReviewBoardService {

  public List<ReviewBoardVO> reviewBoardVO();
  public List<ReviewBoardVO> selectReview();
  
}
