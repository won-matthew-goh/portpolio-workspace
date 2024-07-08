package com.global.moviego.domain;

import java.time.LocalDateTime;

import org.springframework.context.annotation.PropertySource;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@PropertySource("classpath:messages")
public class UserVO {
  private Long userId;
  @NotBlank(message = "{username.notblank}")
  @Size(min = 4, max = 10, message = "{username.size}")
  @Pattern(regexp = "^[a-z0-9]*$", message = "{username.pattern}")
  private String username;

  @NotBlank(message = "{password.notblank}")
  @Size(min = 8, max = 12, message = "{password.size}")
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&+=/]).{8,12}$", message = "{password.pattern}")
  private String passwd;

  @NotBlank(message = "{email.notblank}")
  @Email(message = "{email.valid}")
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
