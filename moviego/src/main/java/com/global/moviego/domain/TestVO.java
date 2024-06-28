package com.global.moviego.domain;


public class TestVO {

  private int userId;
  
  private String username;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "TestVO [userId=" + userId + ", username=" + username + "]";
  }
  
}
