package com.global.moviego.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.domain.MovieListVO;
import com.global.moviego.service.MovieListServiceImpl;

@Controller
public class HomeController {

  @Autowired
  MovieListServiceImpl movieListService;

  @GetMapping("/")
  public String home(Model model) {

    List<MovieListVO> movies = new ArrayList<MovieListVO>();
    model.addAttribute("movies", movies);
    
    return "/index";
  }

}
