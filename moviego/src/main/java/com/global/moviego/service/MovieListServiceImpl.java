package com.global.moviego.service;

import java.util.ArrayList;
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

  public List<MovieListVO> getMovieList(Map<String, Object> paramMap) {
    if (paramMap.get("pageCnt") == null || paramMap.get("pageCnt").equals(""))
      paramMap.put("pageCnt", "1");

    int pageCnt = Integer.parseInt((String) paramMap.get("pageCnt"));

    try {
      String response = restTemplate.getForObject(apiUrl + pageCnt, String.class);

      String responseGenre = restTemplate.getForObject(genreUrl, String.class);

      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(response);
//      JsonNode genreNode = objectMapper.readTree(responseGenre);
      JsonNode moviesNode = rootNode.path("results");
      JsonNode movieGenreNode = moviesNode.path("genre_ids");

      List<MovieListVO> movies = new ArrayList<>();
      for (JsonNode movieNode : moviesNode) {
        MovieListVO movie = new MovieListVO();
        movie.setId(movieNode.path("id").asInt());
        movie.setTitle(movieNode.path("title").asText());
//        movie.setOverview(movieNode.path("overview").asText());
        movie.setPosterPath(movieNode.path("poster_path").asText());
        movie.setBackdropPath(movieNode.path("backdrop_path").asText());
        movie.setReleaseDate(movieNode.path("release_date").asText());
//        movie.setGenreIds(movieNode.path("genre_ids").asInt());
        movie.setOriginalLanguage(movieNode.path("original_language").asText());
        movie.setAdult(movieNode.path("adult").asBoolean());
        movie.setVoteAverage(movieNode.path("vote_average").asInt());
        movie.setVoteCount(movieNode.path("vote_count").asInt());
        movies.add(movie);
      }
      return movies;

    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }

  }

  @Override
  public Map<String, List<String>> getMoiveGenre(Map<String, Object> paramMap) {
    if (paramMap.get("pageCnt") == null || paramMap.get("pageCnt").equals(""))
      paramMap.put("pageCnt", "1");

    int pageCnt = Integer.parseInt((String) paramMap.get("pageCnt"));

    try {
      String response = restTemplate.getForObject(apiUrl + pageCnt, String.class);
      Map<String, List<String>> movieGenresMap = new HashMap<>();

      JSONObject jsonObject = new JSONObject(response);
      JSONArray resultsArray = jsonObject.getJSONArray("results");

      for (int i = 0; i < resultsArray.length(); i++) {
        JSONObject movieObject = resultsArray.getJSONObject(i);
        String movieId = movieObject.getString("id");
        JSONArray genreIdsArray = movieObject.getJSONArray("genre_ids");
        List<String> genreIdsList = new ArrayList<>();
        
        for (int j = 0; j < genreIdsArray.length(); j++) {
          genreIdsList.add(genreIdsArray.getString(j));
        }

        movieGenresMap.put(movieId, genreIdsList);
      }
      return movieGenresMap;
    } catch (Exception e) {
      e.printStackTrace();
      return new HashMap<>();
    }
  };

}
