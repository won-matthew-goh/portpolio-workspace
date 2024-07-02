package com.global.moviego.service;

import java.util.List;
import java.util.Map;

import com.global.moviego.domain.MovieListVO;

public interface MovieListService {

  Map<String, List<MovieListVO>> getMovieList(Map<String, Object> paramMap);
  
//  Map<String, List<String>> getMoiveGenre(Map<String, Object> paramMap);
  
}
