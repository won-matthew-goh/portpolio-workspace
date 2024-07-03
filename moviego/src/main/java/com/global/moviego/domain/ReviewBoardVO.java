package com.global.moviego.domain;

import java.time.LocalDateTime;

public class ReviewBoardVO {
	private int reviewId;
	
	private int userId;
	
	private float rating;
	
	private int movieId;
	
	private String movieNm;
	
	private String title;
	
	private String posterUrl;
	
	private String CreatedAt;
	
	
	public String getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}



}
