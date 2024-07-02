package com.global.moviego.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.domain.MovieListVO;
import com.global.moviego.domain.MovieUpcommingVO;
import com.global.moviego.service.HomeServiceImpl;
import com.global.moviego.service.MovieListServiceImpl;

@Controller
public class HomeController {

  @Autowired
  HomeServiceImpl homeService;

  @GetMapping("/")
  public String home(Model model) {

    List<MovieUpcommingVO> movies = new ArrayList<MovieUpcommingVO>();
    movies = homeService.movieUpcommingList();
//    
//    for(int i = 0; i < movies.size(); i++) {
//      System.out.println(movies.get(i).getBackdropPath());
//    }
//    
    model.addAttribute("movies", movies);
    return "/index";
  }
  
  

}
