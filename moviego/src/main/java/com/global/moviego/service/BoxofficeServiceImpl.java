package com.global.moviego.service;

import com.global.moviego.domain.BoxofficeVO;
import com.global.moviego.util.DateCalc;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class BoxofficeServiceImpl implements BoxofficeService {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private LocaleResolver localeResolver;
    
    @Autowired
    private TmdbService tmdbService;

    @Value("${api.boxoffice.url}")
    private String apiUrl;

    @Override
    public List<BoxofficeVO> getWeeklyBoxOffice(HttpServletRequest request) {
      Locale locale = localeResolver.resolveLocale(request);
        try {
            
            String response = restTemplate.getForObject(apiUrl + DateCalc.getLastWeek(), String.class);
            
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode moviesNode = rootNode.path("boxOfficeResult").path("weeklyBoxOfficeList");

            List<BoxofficeVO> movies = new ArrayList<>();
            for (JsonNode movieNode : moviesNode) {
                BoxofficeVO movie = new BoxofficeVO();
                movie.setMovieNm(movieNode.path("movieNm").asText());
                movie.setOpenDt(movieNode.path("openDt").asText());
                movie.setAudiCnt(movieNode.path("audiCnt").asInt());
                movie.setAudiInten(movieNode.path("audiInten").asInt());
                movie.setAudiAcc(movieNode.path("audiAcc").asInt());
                movie.setRank(movieNode.path("rank").asInt());
                JsonNode tmdbMovie = tmdbService.searchMovie(movie.getMovieNm(), movie.getOpenDt());
                if (tmdbMovie != null) {
                    movie.setTitleEn(tmdbMovie.path("title").asText());
                    movie.setTitleJa(tmdbMovie.path("title").asText()); // 일본어 제목은 별도 API 호출 필요
                }
                movies.add(movie);
            }
            
            return movies;
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

//    private List<BoxofficeVO> parseMovies(String jsonResponse) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode rootNode = objectMapper.readTree(jsonResponse);
//        JsonNode moviesNode = rootNode.path("boxOfficeResult").path("weeklyBoxOfficeList");
//
//        List<BoxofficeVO> movies = new ArrayList<>();
//        for (JsonNode movieNode : moviesNode) {
//            BoxofficeVO movie = new BoxofficeVO();
//            movie.setMovieNm(movieNode.path("movieNm").asText());
//            movie.setOpenDt(movieNode.path("openDt").asText());
//            movie.setAudiCnt(movieNode.path("audiCnt").asInt());
//            movie.setAudiInten(movieNode.path("audiInten").asInt());
//            movie.setAudiAcc(movieNode.path("audiAcc").asInt());
//            movies.add(movie);
//        }
//
//        return movies;
//    }
}
