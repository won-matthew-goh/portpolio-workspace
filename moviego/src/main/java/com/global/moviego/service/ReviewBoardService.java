package com.global.moviego.service;

import java.util.List;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;

public interface ReviewBoardService {
	//게시글 등록
    void register(ReviewBoardVO vo);
    
    //전체 게시글 조회
    List<ReviewBoardVO> getBoard(PageVO vo);
    
    //선택된 게시글 조회
    int getTotal(PageVO vo);
    
    //선택된 게시글 조회
    ReviewBoardVO getBoardById(int reviewId);

    //게시글 수정
    void updateBoard(ReviewBoardVO vo);
    
    //게시글 삭제
    void deleteBoard(int reviewId);
    
    //게시글 신고
    void incrementReportCount(int reviewId);
    
    //조회수 추가
//    void incrementReadCount(int reviewId);
//    
}
