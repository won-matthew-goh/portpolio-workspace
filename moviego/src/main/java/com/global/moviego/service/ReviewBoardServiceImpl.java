package com.global.moviego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.mapper.ReviewBoardMapper;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {
  // @Autowired 리뷰 입력 폼으로 받은 데이터들 가져오는 용도, 오버라이드 해서 사용
  @Autowired
  private ReviewBoardMapper reviewBoardMapper;

  // 글삽입 메소드(Create)
  @Override
  public void register(ReviewBoardVO vo) {
    // vo에 이미 userId가 설정되어 있으므로, 그대로 매퍼를 호출합니다.
    reviewBoardMapper.insert(vo);
  }

  // 게시글 조회 메소드(Read)
  @Override
  public List<ReviewBoardVO> getBoard(PageVO vo) {
    return reviewBoardMapper.getBoard(vo);

  }

  // 페이징 메소드(Paging)
  @Override
  public int getTotal(PageVO vo) {
    return reviewBoardMapper.getTotal(vo);
  }

  @Override
  public ReviewBoardVO getBoardById(int reviewId) {
    return reviewBoardMapper.getBoardById(reviewId);
  }

  // 게시글 수정
  @Override
  public void updateBoard(ReviewBoardVO vo) {
    reviewBoardMapper.updateBoard(vo);
  }

  // 게시글 삭제
  @Override
  public void deleteBoard(int reviewId) {
    reviewBoardMapper.deleteBoard(reviewId);

  }

  // 게시글 신고
  @Override
  public void incrementReportCount(int reviewId) {
    reviewBoardMapper.incrementReportCount(reviewId);
  }

  // 조회수 추가
  @Override
  public void incrementReadCount(int reviewId) {
    reviewBoardMapper.incrementReadCount(reviewId);
  }

  // 관리자 페이지
  public List<ReviewBoardVO> getReportedReviews() {
    List<ReviewBoardVO> reportedReviews = reviewBoardMapper.getReportedReviews();
    System.out.println(reportedReviews); // 데이터가 제대로 들어오는지 로그로 확인
    return reportedReviews;
  }

  @Override
  public void deleteReview(int reviewId) {
    reviewBoardMapper.deleteReview(reviewId);
  }

}