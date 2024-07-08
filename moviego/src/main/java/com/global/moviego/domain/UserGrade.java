package com.global.moviego.domain;

public enum UserGrade {
    REGULAR(0),
    ADMIN(1);

    private final int value;

    UserGrade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserGrade fromValue(int value) {
        for (UserGrade grade : values()) {
            if (grade.value == value) {
                return grade;
            }
        }
        throw new IllegalArgumentException("Unknown UserGrade value: " + value);
    }
    
    public static UserGrade fromName(String name) {
      for (UserGrade grade : values()) {
          if (grade.name().equalsIgnoreCase(name)) {
              return grade;
          }
      }
      throw new IllegalArgumentException("Unknown UserGrade name: " + name);
  }
    
}