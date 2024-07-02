package com.global.moviego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.ReviewBoardVO;

@Repository
@Mapper
public interface ReviewBoardMapper {
	
	public List<ReviewBoardVO> selectReview();
	
//	public List<ReviewBoardVO> saveResult();
//	
//	public int selectReviewCnt();
}
