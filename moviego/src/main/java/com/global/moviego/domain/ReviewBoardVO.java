package com.global.moviego.domain;

import java.time.LocalDateTime;

public class ReviewBoardVO {
	private int userId;
	
	private int rating;
	
	private String username;
	
	private String movieId;
	
	private String movieNm;
	
	private String posterUrl;
	
	private String comment;
		
	private LocalDateTime createdAt;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getMovieNm() {
    return movieNm;
  }

  public void setMovieNm(String movieNm) {
    this.movieNm = movieNm;
  }

  public String getPosterUrl() {
    return posterUrl;
  }

  public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
	

}
