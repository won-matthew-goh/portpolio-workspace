package com.global.moviego.domain;

import jakarta.validation.constraints.NotBlank;

public class LoginVO {
  @NotBlank(message = "유저명은 필수 입력 사항입니다.")
  private String username;

  @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
}
