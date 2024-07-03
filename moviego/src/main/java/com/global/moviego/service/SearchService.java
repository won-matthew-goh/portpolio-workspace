package com.global.moviego.service;

import java.util.List;
import java.util.Map;

import com.global.moviego.domain.MovieListVO;

public interface SearchService {

	Map<String, Object> getSearch(Map<String, Object> paramMap);
}
