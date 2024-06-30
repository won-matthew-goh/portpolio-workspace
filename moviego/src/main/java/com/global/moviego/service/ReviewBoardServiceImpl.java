package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.mapper.ReviewBoardMapper;

@Service
public class ReviewBoardServiceImpl {
	@Autowired //리뷰 입력 폼으로 받은 데이터들 가져오는 용도, 오버라이드 해서 사용
	private ReviewBoardMapper reviewboarderMapper;
	
	
}
