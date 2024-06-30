package com.global.moviego.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.global.moviego.domain.BoxofficeVO;
import com.global.moviego.service.BoxofficeServiceImpl;

@Controller
//@RequestMapping("/boxoffice")
public class BoxofficeController {
  
  @Autowired BoxofficeServiceImpl boxofficeService;

  @GetMapping("/boxoffice")
  public String boxoffice(Model model) {
    List<BoxofficeVO> movies = boxofficeService.getWeeklyBoxOffice();
    
    for(int i = 0; i < movies.size(); i++) {
    System.out.println(movies.get(i).getMovieNm());
    System.out.println(movies.get(i).getAudiCnt());
    }
    
    model.addAttribute("movies", movies);
    return "/boxoffice";
  }
  
}
