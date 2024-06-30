package com.global.moviego.service;

import com.global.moviego.domain.BoxofficeVO;
import com.global.moviego.util.DateCalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoxofficeServiceImpl implements BoxofficeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.boxoffice.url}")
    private String apiUrl;

    @Override
    public List<BoxofficeVO> getWeeklyBoxOffice() {
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
