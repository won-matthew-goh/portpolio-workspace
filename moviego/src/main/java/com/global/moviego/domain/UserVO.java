package com.global.moviego.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserVO {
  private Long userId;
  @NotEmpty(message = "username을 입력해주세요.")
  @Size(min = 4, max = 10, message = "Username은 최소 4자에서 최대 10자입니다.")
  @Pattern(regexp = "^[a-z0-9]+$", message = "Username은 오로지 영문 소문자와 숫자로만 가능합니다.")
  private String username;
  @NotEmpty(message = "비밀번호를 입력해주세요.")
  @Size(min = 8, max = 12, message = "비밀번호는 최소 8자에서 최대 12자로 이루어집니다.")
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$", message = "비밀번호는 영문 대문자, 소문자, 특수문자와 숫자를 혼합해야 합니다.")
  private String passwd;
  @NotEmpty(message = "email이 필요합니다.")
  @Email(message = "email형식이 맞지 않습니다.")
  private String email;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
  private String provider;
  private String providerId;
  private UserGrade grade;

  // Getters and Setters

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public LocalDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(LocalDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public UserGrade getGrade() {
    return grade;
  }

  public void setGrade(UserGrade grade) {
    this.grade = grade;
  }

  public int getGradeValue() {
    return grade != null ? grade.getValue() : UserGrade.REGULAR.getValue();
  }

}
