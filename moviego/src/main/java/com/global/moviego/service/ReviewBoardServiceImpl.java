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
	
	//게시글 수정
	@Override
	public void updateBoard(ReviewBoardVO vo) {
		reviewBoardMapper.updateBoard(vo);
	}
	
	//게시글 삭제
	@Override
	public void deleteBoard(int reviewId) {
		reviewBoardMapper.deleteBoard(reviewId);

	}
	
	// 관리자 페이지
    public List<ReviewBoardVO> getAllReviews() {
        return reviewBoardMapper.getAllReviews();
    }

    public void deleteReview(int reviewId) {
        reviewBoardMapper.deleteReview(reviewId);
    }

}