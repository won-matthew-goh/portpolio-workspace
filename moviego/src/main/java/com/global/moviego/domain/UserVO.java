package com.global.moviego.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserVO {
  private Long userId;
  @NotBlank(message = "유저명은 필수 입력 사항입니다.")
  @Size(min = 4, max = 10, message = "유저명은 4자 이상 10자 이하로 입력해주세요.")
  @Pattern(regexp = "^[a-z0-9]*$", message = "유저명은 영문 소문자와 숫자만 사용할 수 있습니다.")
  private String username;

  @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
  @Size(min = 8, max = 12, message = "비밀번호는 8자 이상 12자 이하로 입력해주세요.")
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&+=/]).{8,12}$", message = "비밀번호는 영문 대소문자, 숫자, 특수문자(!@#$%^&+=/)를 포함해야 하며 8자 이상 12자 이하로 입력해주세요.")
  private String passwd;

  @NotBlank(message = "이메일은 필수 입력 사항입니다.")
  @Email(message = "유효한 이메일 주소를 입력해주세요.")
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

  public void setGradeValue(int value) {
    this.grade = UserGrade.fromValue(value);
  }

}
