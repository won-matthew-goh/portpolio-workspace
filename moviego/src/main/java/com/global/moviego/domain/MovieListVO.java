package com.global.moviego.domain;

import java.util.List;

public class MovieListVO {
  
  private int id;
  
  private String title;
  
  private String overview;
  
  private String posterPath;
  
  private String backdropPath;
  
  private String releaseDate;
  
  private int genreIds;
  
  private String originalLanguage;

  private boolean adult;
  
  private int voteAverage;
  
  private int voteCount;
  
  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public int getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(int genreIds) {
    this.genreIds = genreIds;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public int getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(int voteAverage) {
    this.voteAverage = voteAverage;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

  
}
