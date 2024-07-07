package com.global.moviego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;

@Repository
@Mapper
public interface ReviewBoardMapper {
	// mapper.xml에서 id=insert 실행
	void insert(ReviewBoardVO vo);

	List<ReviewBoardVO> getBoard(PageVO vo);

	int getTotal(PageVO vo);

	ReviewBoardVO getBoardById(int reviewId);

	void updateBoard(ReviewBoardVO vo);
	
	void deleteBoard(int reviewId);
}
