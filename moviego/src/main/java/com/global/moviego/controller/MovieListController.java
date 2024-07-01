package com.global.moviego.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.domain.BoxofficeVO;
import com.global.moviego.domain.MovieListVO;
import com.global.moviego.service.MovieListService;
import com.global.moviego.service.MovieListServiceImpl;

@Controller
public class MovieListController {

  @Autowired
  MovieListServiceImpl movieListService;

  @GetMapping("/movieList")
  public String movieList(Model model) {
    List<MovieListVO> movies = movieListService.getMovieList();

    for (int i = 0; i < movies.size(); i++) {
      System.out.println(movies.get(i).getTitle());
      System.out.println(movies.get(i).getOverview());
      System.out.println(movies.get(i).getPosterPath());
    }

    model.addAttribute("movies", movies);
    return "/movielist";
  }

}
