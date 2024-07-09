package com.global.moviego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.global.moviego"})
public class MoviegoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoviegoApplication.class, args);
    }
}
