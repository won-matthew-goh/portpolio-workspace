package com.global.moviego.service;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.moviego.domain.MovieListVO;

@Service
public class SearchServiceImpl implements SearchService {
	// ReviewBoard 검색창
	@Override
	public Map<String, Object> getReviewSearch(Map<String, Object> paramMap) {
		ㄴㄴㄴㄴㄴㄴ
		return null;
	}
	
	// MovieList 검색창

	@Autowired
	private RestTemplate restTemplate;

	@Value("${search.tmdb.url}")
	private String searchApiUrl;

	@Override
	public Map<String, Object> getMovieSearch(Map<String, Object> paramMap) {
		String paramQuery = (String) paramMap.get("query");

		try {
			String response = restTemplate.getForObject(searchApiUrl + paramQuery, String.class);
			return parseSearch(response);
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}
	}
	
	  private Map<String, Object> parseSearch(String response) throws IOException {
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
		      movie.setVoteAverage(movieNode.path("vote_average").asInt());
		      movie.setVoteCount(movieNode.path("vote_count").asInt());
		      movie.setGenreIds(objectMapper.convertValue(movieNode.path("genre_ids"), new TypeReference<List<Integer>>() {
		      }));
		      movies.add(movie);
		    }

		    Map<String, Object> movieMap = new HashMap<>();
		    movieMap.put("movies", movies);
		    return movieMap;
		  }


}
