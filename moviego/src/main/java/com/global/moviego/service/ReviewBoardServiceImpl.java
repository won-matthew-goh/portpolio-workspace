package com.global.moviego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.mapper.ReviewBoardMapper;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {
	//@Autowired 리뷰 입력 폼으로 받은 데이터들 가져오는 용도, 오버라이드 해서 사용
	@Autowired
	private ReviewBoardMapper reviewBoardMapper;
	//글삽입 메소드(Create)
	@Override
	public void register(ReviewBoardVO vo) {
		reviewBoardMapper.insert(vo);
	}
	
	//게시글 조회 메소드(Read)
	@Override
	public List<ReviewBoardVO> getFreeBoard() {
		return reviewBoardMapper.getFreeBoard();
	}
	
	
	//페이징 메소드(Paging)
	@Override
	public int getTotal(PageVO vo) {
		return reviewBoardMapper.getTotal(vo);
	}
	
//	}
//	//조회수 카운트 메소드
//	@Override
//	public int selectReviewCnt() {
//		int cnt = reviewBoardMapper.selectReviewCnt();
//		return cnt;
//	}
//	
	//게시글 수정 메소드(Update)
	//게시글 삭제 메소드(Delete)
  
//	@Override
//	public List<ReviewBoardVO> selectReviewService(){
//		List<ReviewBoardVO> select = new ArrayList<ReviewBoardVO>();
//		select = reviewBoardMapper.selectReview();
//		return select;
//	}
}
