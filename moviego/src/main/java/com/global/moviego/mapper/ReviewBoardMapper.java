package com.global.moviego.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;

@Repository
@Mapper
public interface ReviewBoardMapper {
	//mapper.xml에서 id=insert 실행
	public void insert(ReviewBoardVO vo);
		
	public List<ReviewBoardVO> getFreeBoard();
	
	public int getTotal(PageVO vo);

//	public List<ReviewBoardVO> selectReview();
	
	  List<ReviewBoardVO> getReviewSearch(@Param("keyword") String keyword, @Param("searchOption") String searchOption);
	}
