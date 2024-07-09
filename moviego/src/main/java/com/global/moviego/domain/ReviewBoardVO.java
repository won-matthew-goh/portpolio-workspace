package com.global.moviego.domain;

public class ReviewBoardVO {
	private Long reviewId;
	
	private int userId;
	
	private float rating;
	
	private int movieId;
	
	private int readCnt;
	
	private int reportCnt;

	private String movieNm;
	
	private String title;
	
	private String posterUrl;
	
	private String createdAt;
	
	private String comment;
	
	private String username;
	
	private String movieNmEn;
	
  private String movieNmJa;
	
	public int getReportCnt() {
		return reportCnt;
	}
	
	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
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

  public String getMovieNmEn() {
    return movieNmEn;
  }

  public void setMovieNmEn(String movieNmEn) {
    this.movieNmEn = movieNmEn;
  }

  public String getMovieNmJa() {
    return movieNmJa;
  }

  public void setMovieNmJa(String movieNmJa) {
    this.movieNmJa = movieNmJa;
  }

}
