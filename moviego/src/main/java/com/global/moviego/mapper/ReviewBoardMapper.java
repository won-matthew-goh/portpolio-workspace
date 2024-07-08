package com.global.moviego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;

@Repository
@Mapper
public interface ReviewBoardMapper {
	//search
    List<ReviewBoardVO> getReviewSearch(
            @Param("keyword") String keyword,
            @Param("searchOption") String searchOption,
            @Param("offset") int offset,
            @Param("countPerPage") int countPerPage
        );

        int getReviewSearchTotal(
            @Param("keyword") String keyword,
            @Param("searchOption") String searchOption
        );
		
	// mapper.xml에서 id=insert 실행
	void insert(ReviewBoardVO vo);

	List<ReviewBoardVO> getBoard(PageVO vo);

	int getTotal(PageVO vo);

	ReviewBoardVO getBoardById(@Param("reviewId") int reviewId);

	void updateBoard(ReviewBoardVO vo);

	void deleteBoard(@Param("reviewId") int reviewId);
	
	//getPosterUrl 가져오기
	ReviewBoardVO getPosterUrl(@Param("posterUrl") String posterUrl);
	
	//게시글 신고 카운트
    void incrementReportCount(@Param("reviewId") int reviewId);

	//조회수 추가
//    void incrementReadCount(@Param("reviewId") int reviewId);
}
