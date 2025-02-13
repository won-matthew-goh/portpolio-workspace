package com.global.moviego.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.moviego.domain.MovieListVO;
import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.mapper.ReviewBoardMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class SearchServiceImpl implements SearchService {

	// ReviewBoard 검색창
	@Autowired
	private ReviewBoardMapper reviewBoardMapper;

	@Override
	public Map<String, Object> getReviewSearch(Map<String, Object> paramMap) {
		String paramKeyword = (String) paramMap.get("keyword");
		String searchOption = (String) paramMap.get("searchOption");
		int offset = (int) paramMap.get("offset");
		int countPerPage = (int) paramMap.get("countPerPage");

		if (paramKeyword == null || paramKeyword.isEmpty() || searchOption == null || searchOption.equals("0")) {
			return new HashMap<>();
		}
		List<ReviewBoardVO> results = reviewBoardMapper.getReviewSearch(paramKeyword, searchOption, offset,
				countPerPage);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("results", results);

		return resultMap;
	}

	@Override
	public int getReviewSearchTotal(Map<String, Object> paramMap) {
		String paramKeyword = (String) paramMap.get("keyword");
		String searchOption = (String) paramMap.get("searchOption");
		return reviewBoardMapper.getReviewSearchTotal(paramKeyword, searchOption);
	}

	// MovieList 검색창
	@Autowired
	private RestTemplate restTemplate;
	
  @Autowired
  private LocaleResolver localeResolver;

	@Value("${search.tmdb.url}")
	private String searchApiUrl;

	@Override
	public Map<String, Object> getMovieSearch(Map<String, Object> paramMap, HttpServletRequest request) {
	    String paramQuery = (String) paramMap.get("query");
	    if (paramQuery == null || paramQuery.isEmpty()) {
	        return Collections.emptyMap();
	    }

	    Locale locale = localeResolver.resolveLocale(request);
	    String languageCode = locale.getLanguage();
	    String url = searchApiUrl + "&language=" + languageCode + "&query=" + encodeValue(paramQuery);

	    try {
	        String response = restTemplate.getForObject(url, String.class);
	        return parseSearch(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyMap();
	    }
	}

	private String encodeValue(String value) {
	    try {
	        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
	    } catch (UnsupportedEncodingException ex) {
	        throw new RuntimeException(ex.getCause());
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
			movie.setGenreIds(
					objectMapper.convertValue(movieNode.path("genre_ids"), new TypeReference<List<Integer>>() {
					}));
			movies.add(movie);
		}

		Map<String, Object> movieMap = new HashMap<>();
		movieMap.put("movies", movies);
		return movieMap;
	}

}
