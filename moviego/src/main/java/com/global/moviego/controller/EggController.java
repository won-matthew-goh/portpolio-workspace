package com.global.moviego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EggController {

  @GetMapping("/easteregggggggg/SAMUI")
  public String samui() {
    return "sample/egg";
  }
  
}
