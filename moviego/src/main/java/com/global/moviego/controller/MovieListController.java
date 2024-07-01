package com.global.moviego.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MovieListController {
	
	@GetMapping("/moviego/movieList")
	public String movieList() {
	
		
		
		return "movielist";
	}
	

}
