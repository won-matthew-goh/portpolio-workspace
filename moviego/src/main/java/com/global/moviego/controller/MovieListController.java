package com.global.moviego.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.moviego.domain.MovieListVO;
import com.global.moviego.service.MovieListServiceImpl;
import com.global.moviego.service.SearchServiceImpl;

@Controller
public class MovieListController {

	@Autowired
	MovieListServiceImpl movieListService;

	@Autowired
	SearchServiceImpl searchService;

	@GetMapping("/movieList")
	public String movieList(Model model) {

		return "movielist";
	}

	@GetMapping("/movieList/ajax")
	public @ResponseBody Map<String, List<MovieListVO>> movieListAjax(@RequestParam Map<String, Object> paramMap) {

		return movieListService.getMovieList(paramMap);
	}

	@GetMapping("/movieList/search")
	public @ResponseBody Map<String, Object> searchAjax(@RequestParam Map<String, Object> paramMap) {
		System.out.println(searchService.getSearch(paramMap));
		return searchService.getSearch(paramMap);

	}

}
