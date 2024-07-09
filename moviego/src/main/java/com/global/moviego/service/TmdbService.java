package com.global.moviego.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TmdbService {
  @Value("${search.tmdb.url}")
  private String apiUrl;

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public TmdbService(RestTemplate restTemplate, ObjectMapper objectMapper) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
  }

  public JsonNode searchMovie(String title, String releaseDate) {
    String url = String.format("%s%s&primary_release_date=%s", apiUrl, title, releaseDate);
    String response = restTemplate.getForObject(url, String.class);
    try {
      JsonNode rootNode = objectMapper.readTree(response);
      JsonNode results = rootNode.path("results");
      if (results.size() > 0) {
        return results.get(0);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}