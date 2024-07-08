package com.global.moviego.service;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public interface SearchService {

	// ReviewBoard 검색창
	Map<String, Object> getReviewSearch(Map<String, Object> paramMap);

	// MovieList 검색창
	Map<String, Object> getMovieSearch(Map<String, Object> paramMap, HttpServletRequest request);

	int getReviewSearchTotal(Map<String, Object> paramMap);
}
