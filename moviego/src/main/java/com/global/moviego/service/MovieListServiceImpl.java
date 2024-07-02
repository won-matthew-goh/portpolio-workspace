package com.global.moviego.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.moviego.domain.MovieListVO;

@Service
public class MovieListServiceImpl implements MovieListService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${movielist.tmdb.url}")
  private String apiUrl;

  @Value("${genre.tmdb.url}")
  private String genreUrl;

  @Override
  public Map<String, List<MovieListVO>> getMovieList(Map<String, Object> paramMap) {
    String pageCnt = (String) paramMap.getOrDefault("pageCnt", "1");

    try {
      String response = restTemplate.getForObject(apiUrl + pageCnt, String.class);
      return parseMovieList(response);
    } catch (Exception e) {
      e.printStackTrace();
      return Collections.emptyMap();
    }
  }

  private Map<String, List<MovieListVO>> parseMovieList(String response) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode rootNode = objectMapper.readTree(response);
    JsonNode moviesNode = rootNode.path("results");

    List<MovieListVO> movies = new ArrayList<>();
    for (JsonNode movieNode : moviesNode) {
      MovieListVO movie = new MovieListVO();
      movie.setId(movieNode.path("id").asInt());
      movie.setTitle(movieNode.path("title").asText());
      movie.setOverview(movieNode.path("overview").asText());
      movie.setPosterPath(movieNode.path("poster_path").asText());
      movie.setBackdropPath(movieNode.path("backdrop_path").asText());
      movie.setOriginalLanguage(movieNode.path("original_language").asText());
      movie.setReleaseDate(movieNode.path("release_date").asText());
      movie.setGenreIds(objectMapper.convertValue(movieNode.path("genre_ids"), new TypeReference<List<Integer>>() {
      }));
      movies.add(movie);
    }

    Map<String, List<MovieListVO>> movieMap = new HashMap<>();
    movieMap.put("movies", movies);
    return movieMap;
  }

//  public Map<String, List<String>> getMovieList(Map<String, Object> paramMap) {
//    if (paramMap.get("pageCnt") == null || paramMap.get("pageCnt").equals(""))
//      paramMap.put("pageCnt", "1");
//
//    int pageCnt = Integer.parseInt((String) paramMap.get("pageCnt"));
//
//    try {
//      String response = restTemplate.getForObject(apiUrl + pageCnt, String.class);
//
//      ObjectMapper objectMapper = new ObjectMapper();
//      JsonNode rootNode = objectMapper.readTree(response);
//      JsonNode moviesNode = rootNode.path("results");
//      JsonNode movieGenreNode = moviesNode.path("genre_ids");
//
//      Map<String, List<String>> movies = new HashMap<>();
//      for (JsonNode movieNode : moviesNode) {
//        MovieListVO movie = new MovieListVO();
//        movie.setId(movieNode.path("id").asInt());
//        movie.setTitle(movieNode.path("title").asText());
//        movie.setOverview(movieNode.path("overview").asText());
//        movie.setPosterPath(movieNode.path("poster_path").asText());
//        movie.setBackdropPath(movieNode.path("backdrop_path").asText());
//        movie.setReleaseDate(movieNode.path("release_date").asText());
//        movie.setGenreIds(movieNode.path("genre_ids").asInt());
//        movie.setOriginalLanguage(movieNode.path("original_language").asText());
//        movie.setAdult(movieNode.path("adult").asBoolean());
//        movie.setVoteAverage(movieNode.path("vote_average").asInt());
//        movie.setVoteCount(movieNode.path("vote_count").asInt());
//        movies.put(movie);
//      }
//      return movies;
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      return new HashMap<>();
//    }
//
//  }

//  @Override
//  public Map<String, List<String>> getMoiveGenre(Map<String, Object> paramMap) {
//    if (paramMap.get("pageCnt") == null || paramMap.get("pageCnt").equals(""))
//      paramMap.put("pageCnt", "1");
//
//    int pageCnt = Integer.parseInt((String) paramMap.get("pageCnt"));
//
//    try {
//      String response = restTemplate.getForObject(apiUrl + pageCnt, String.class);
//      Map<String, List<String>> movieGenresMap = new HashMap<>();
//
//      JSONObject jsonObject = new JSONObject(response);
//      JSONArray resultsArray = jsonObject.getJSONArray("results");
//
//      for (int i = 0; i < resultsArray.length(); i++) {
//        JSONObject movieObject = resultsArray.getJSONObject(i);
//        String movieId = movieObject.getString("id");
//        JSONArray genreIdsArray = movieObject.getJSONArray("genre_ids");
//        List<String> genreIdsList = new ArrayList<>();
//        
//        for (int j = 0; j < genreIdsArray.length(); j++) {
//          genreIdsList.add(genreIdsArray.getString(j));
//        }
//
//        movieGenresMap.put(movieId, genreIdsList);
//      }
//      return movieGenresMap;
//    } catch (Exception e) {
//      e.printStackTrace();
//      return new HashMap<>();
//    }
//  };

}
