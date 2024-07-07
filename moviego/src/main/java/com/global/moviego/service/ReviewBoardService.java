package com.global.moviego.service;

import java.util.List;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;

public interface ReviewBoardService {

    void register(ReviewBoardVO vo);

    List<ReviewBoardVO> getBoard(PageVO vo);

    int getTotal(PageVO vo);
    
    ReviewBoardVO getBoardById(int reviewId);

    void updateBoard(ReviewBoardVO vo);
  
    void deleteBoard(int reviewId);
}
