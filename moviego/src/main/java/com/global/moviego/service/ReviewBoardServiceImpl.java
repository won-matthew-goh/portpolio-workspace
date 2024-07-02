package com.global.moviego.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.mapper.ReviewBoardMapper;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {
//	@Autowired //리뷰 입력 폼으로 받은 데이터들 가져오는 용도, 오버라이드 해서 사용
//	private ReviewBoardMapper reviewboarderMapper;
	
	@Autowired
	private ReviewBoardMapper reviewBoardMapper;
	
	@Override
	public List<ReviewBoardVO> reviewBoardVO() {
	  List<ReviewBoardVO> list = new ArrayList<ReviewBoardVO>();
	  list = reviewBoardMapper.saveResult();
	  return list;
	}
	@Override
	public List<ReviewBoardVO> selectReview(){
		List<ReviewBoardVO> select = new ArrayList<ReviewBoardVO>();
		select = reviewBoardMapper.selectReview();
		return select;
	}
	@Override
	public int selectReviewCnt() {
		int cnt = reviewBoardMapper.selectReviewCnt();
		return cnt;
	}

  
}
