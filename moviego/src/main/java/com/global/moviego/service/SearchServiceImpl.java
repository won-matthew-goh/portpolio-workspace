package com.global.moviego.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.global.moviego.domain.MovieListVO;

@Service
public class SearchServiceImpl implements SearchService {
	
	  @Autowired
	  private RestTemplate restTemplate;

	  @Value("${movielist.tmdb.url}")
	  private String apiUrl;

	@Override
	public Map<String, Object> getSearch(Map<String, Object> paramMap) {
		String query = paramMap.toString();
		
		
		
		return null;
	}
	
	

}
