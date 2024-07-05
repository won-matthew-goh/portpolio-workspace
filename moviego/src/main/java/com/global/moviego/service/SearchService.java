package com.global.moviego.service;

import java.util.List;
import java.util.Map;

import com.global.moviego.domain.MovieListVO;

public interface SearchService {
	
	// ReviewBoard 검색창
	Map<String, Object> getReviewSearch(Map<String, Object> paramMap);

	// MovieList 검색창
	Map<String, Object> getMovieSearch(Map<String, Object> paramMap);
}
