package com.global.moviego.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.moviego.domain.MovieListVO;
import com.global.moviego.service.SearchServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	SearchServiceImpl searchService;
	
	@GetMapping("/movieList/ajax/search")
	public @ResponseBody Map<String, List<MovieListVO>> searchAjax(@RequestParam Map<String, Object> paramMap) {
	      
	    return searchService.getSearch(paramMap);
	  }
	

}
