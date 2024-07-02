package com.global.moviego.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.moviego.domain.MovieUpcommingVO;

@Service
public class HomeServiceImpl implements HomeService {
  
  @Autowired
  RestTemplate restTemplate;
  
  @Value("${upcomming.tmdb.url}")
  private String apiUrl;

  @Override
  public List<MovieUpcommingVO> movieUpcommingList() {
    String response = restTemplate.getForObject(apiUrl, String.class);

    try {
      
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode;
      rootNode = objectMapper.readTree(response);
      JsonNode moviesNode = rootNode.path("results");
      
      List<MovieUpcommingVO> movies = new ArrayList<>();
      for(JsonNode movieNode : moviesNode) {
        MovieUpcommingVO movie = new MovieUpcommingVO();
        movie.setTitle(movieNode.path("title").asText());
        movie.setOverview(movieNode.path("overview").asText());
        movie.setPosterPath(movieNode.path("poster_path").asText());
        movie.setBackdropPath(movieNode.path("backdrop_path").asText());
        movie.setReleaseDate(movieNode.path("release_date").asText());
        
        movies.add(movie);
      }
      
      return movies;
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
    
    
    
  }

  
  
}