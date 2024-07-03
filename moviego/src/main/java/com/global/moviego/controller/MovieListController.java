package com.global.moviego.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.moviego.domain.MovieListVO;
import com.global.moviego.service.MovieListServiceImpl;

@Controller
public class MovieListController {

  @Autowired
  MovieListServiceImpl movieListService;

  @GetMapping("/movieList")
  public String movieList(Model model) {

    return "/movielist";
  }
  
  @GetMapping("/movieList/ajax")
  public @ResponseBody Map<String, List<MovieListVO>> movieListAjax(@RequestParam Map<String, Object> paramMap) {
      
    return movieListService.getMovieList(paramMap);
  }
}
