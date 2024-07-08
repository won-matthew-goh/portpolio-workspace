package com.global.moviego.service;

import java.util.Map;

public interface SearchService {

	// ReviewBoard 검색창
	Map<String, Object> getReviewSearch(Map<String, Object> paramMap);

	// MovieList 검색창
	Map<String, Object> getMovieSearch(Map<String, Object> paramMap);

	int getReviewSearchTotal(Map<String, Object> paramMap);
}
