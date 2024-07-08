package com.global.moviego.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.moviego.domain.MovieListVO;
import com.global.moviego.service.MovieListServiceImpl;
import com.global.moviego.service.SearchServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MovieListController {

	@Autowired
	MovieListServiceImpl movieListService;

	@Autowired
	SearchServiceImpl searchService;
	
	@Autowired
  private MessageSource messageSource;

	@GetMapping("/movieList")
	public String movieList(Model model) {

		return "movielist";
	}

	@GetMapping("/movieList/ajax")
	public @ResponseBody Map<String, List<MovieListVO>> movieListAjax(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {

		return movieListService.getMovieList(paramMap, request);
	}

	@GetMapping("/movieList/search")
	public @ResponseBody Map<String, Object> searchAjax(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
		System.out.println(searchService.getMovieSearch(paramMap, request));
		return searchService.getMovieSearch(paramMap, request);

	}
	
	@GetMapping("/movieList/messages")
	@ResponseBody
	public Map<String, String> getMessages(Locale locale) {
	    Map<String, String> messages = new HashMap<>();
	    messages.put("releaseDate", messageSource.getMessage("movie.release.date", null, locale));
	    messages.put("country", messageSource.getMessage("movie.country", null, locale));
	    messages.put("genre", messageSource.getMessage("movie.genre", null, locale));
	    messages.put("rating", messageSource.getMessage("movie.rating", null, locale));
	    messages.put("voteCount", messageSource.getMessage("movie.vote.count", null, locale));
	    messages.put("overviewNotProvided", messageSource.getMessage("movie.overview.not.provided", null, locale));
	    messages.put("reviewRegister", messageSource.getMessage("movie.review.register", null, locale));
	    messages.put("modalClose", messageSource.getMessage("movie.modal.close", null, locale));
	    return messages;
	}
	
	@GetMapping("/movieList/genres")
	@ResponseBody
	public Map<Integer, String> getGenres(Locale locale) {
	    Map<Integer, String> genres = new HashMap<>();
	    genres.put(28, messageSource.getMessage("genre.action", null, locale));
	    genres.put(12, messageSource.getMessage("genre.adventure", null, locale));
	    genres.put(16, messageSource.getMessage("genre.animation", null, locale));
	    genres.put(35, messageSource.getMessage("genre.comedy", null, locale));
	    genres.put(80, messageSource.getMessage("genre.crime", null, locale));
	    genres.put(99, messageSource.getMessage("genre.documentary", null, locale));
	    genres.put(18, messageSource.getMessage("genre.drama", null, locale));
	    genres.put(10751, messageSource.getMessage("genre.family", null, locale));
	    genres.put(14, messageSource.getMessage("genre.fantasy", null, locale));
	    genres.put(36, messageSource.getMessage("genre.history", null, locale));
	    genres.put(27, messageSource.getMessage("genre.horror", null, locale));
	    genres.put(10402, messageSource.getMessage("genre.music", null, locale));
	    genres.put(9648, messageSource.getMessage("genre.mystery", null, locale));
	    genres.put(10749, messageSource.getMessage("genre.romance", null, locale));
	    genres.put(878, messageSource.getMessage("genre.scifi", null, locale));
	    genres.put(10770, messageSource.getMessage("genre.tv_movie", null, locale));
	    genres.put(53, messageSource.getMessage("genre.thriller", null, locale));
	    genres.put(10752, messageSource.getMessage("genre.war", null, locale));
	    genres.put(37, messageSource.getMessage("genre.western", null, locale));
	    
	    return genres;
	}

	@GetMapping("/movieList/countries")
	@ResponseBody
	public Map<String, String> getCountries(Locale locale) {
	    Map<String, String> countries = new HashMap<>();
	    countries.put("en", messageSource.getMessage("country.us", null, locale));
	    countries.put("ko", messageSource.getMessage("country.kr", null, locale));
	    countries.put("bn", messageSource.getMessage("country.bn", null, locale));
	    countries.put("pl", messageSource.getMessage("country.pl", null, locale));
	    countries.put("th", messageSource.getMessage("country.th", null, locale));
	    countries.put("us", messageSource.getMessage("country.us", null, locale));
	    countries.put("kr", messageSource.getMessage("country.kr", null, locale));
	    countries.put("ja", messageSource.getMessage("country.jp", null, locale));
	    countries.put("zh", messageSource.getMessage("country.cn", null, locale));
	    countries.put("fr", messageSource.getMessage("country.fr", null, locale));
	    countries.put("de", messageSource.getMessage("country.de", null, locale));
	    countries.put("in", messageSource.getMessage("country.in", null, locale));
	    countries.put("it", messageSource.getMessage("country.it", null, locale));
	    countries.put("es", messageSource.getMessage("country.es", null, locale));
	    countries.put("ru", messageSource.getMessage("country.ru", null, locale));
	    countries.put("br", messageSource.getMessage("country.br", null, locale));
	    countries.put("mx", messageSource.getMessage("country.mx", null, locale));
	    countries.put("ca", messageSource.getMessage("country.ca", null, locale));
	    countries.put("au", messageSource.getMessage("country.au", null, locale));
	    countries.put("gb", messageSource.getMessage("country.gb", null, locale));
	    countries.put("se", messageSource.getMessage("country.se", null, locale));
	    countries.put("no", messageSource.getMessage("country.no", null, locale));
	    countries.put("fi", messageSource.getMessage("country.fi", null, locale));
	    countries.put("nl", messageSource.getMessage("country.nl", null, locale));
	    countries.put("be", messageSource.getMessage("country.be", null, locale));
	    countries.put("ch", messageSource.getMessage("country.ch", null, locale));
	    countries.put("at", messageSource.getMessage("country.at", null, locale));
	    countries.put("dk", messageSource.getMessage("country.dk", null, locale));
	    countries.put("nz", messageSource.getMessage("country.nz", null, locale));
	    countries.put("sg", messageSource.getMessage("country.sg", null, locale));
	    countries.put("my", messageSource.getMessage("country.my", null, locale));
	    countries.put("id", messageSource.getMessage("country.id", null, locale));
	    countries.put("ph", messageSource.getMessage("country.ph", null, locale));
	    countries.put("vn", messageSource.getMessage("country.vn", null, locale));
	    countries.put("sa", messageSource.getMessage("country.sa", null, locale));
	    countries.put("ae", messageSource.getMessage("country.ae", null, locale));
	    countries.put("eg", messageSource.getMessage("country.eg", null, locale));
	    countries.put("za", messageSource.getMessage("country.za", null, locale));
	    countries.put("ar", messageSource.getMessage("country.ar", null, locale));
	    countries.put("cl", messageSource.getMessage("country.cl", null, locale));
	    countries.put("co", messageSource.getMessage("country.co", null, locale));
	    countries.put("pe", messageSource.getMessage("country.pe", null, locale));
	    countries.put("pt", messageSource.getMessage("country.pt", null, locale));

	    return countries;
	}

}
