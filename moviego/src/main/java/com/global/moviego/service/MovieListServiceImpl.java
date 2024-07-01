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
import com.global.moviego.domain.BoxofficeVO;
import com.global.moviego.domain.MovieListVO;

@Service
public class MovieListServiceImpl implements MovieListService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${movielist.tmdb.url}")
  private String apiUrl;
  
  public List<MovieListVO> getMovieList() {
    int pageCnt = 1;
    
    try {
      String response = restTemplate.getForObject(apiUrl + pageCnt, String.class);
      
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(response);
      JsonNode pagesNode = rootNode.path("page");
      JsonNode moviesNode = rootNode.path("results");
      
      List<MovieListVO> movies = new ArrayList<>();
        for (JsonNode movieNode : moviesNode) {
            MovieListVO movie = new MovieListVO();
            movie.setId(movieNode.path("id").asInt());
            movie.setTitle(movieNode.path("title").asText());
            movie.setOverview(movieNode.path("overview").asText());
            movie.setPosterPath(movieNode.path("poster_path").asText());
            movie.setBackdropPath(movieNode.path("backdrop_path").asText());
            movie.setReleaseDate(movieNode.path("release_date").asText());
            movie.setGenreIds(movieNode.path("genre_ids").asInt());
            movie.setOriginalLanguage(movieNode.path("original_language").asText());
            movie.setAdult(movieNode.path("adult").asBoolean());
            movie.setVoteAverage(movieNode.path("vote_average").asInt());
            movie.setVoteCount(movieNode.path("vote_count").asInt());
            movie.setPage(pagesNode.path("page").asInt());
            
            movies.add(movie);
        }
        pageCnt++;
      return movies;
      
      
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
    
  }
  
}
