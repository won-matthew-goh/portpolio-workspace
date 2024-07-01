package com.global.moviego.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.domain.TestVO;
import com.global.moviego.service.TestService;

@Controller
public class TestController {
  
  @Autowired
  private TestService testService;
   
  @GetMapping("/test")
  public String test(Model model, @RequestParam("userId") int userId) {
    List<TestVO> list = new ArrayList<TestVO>();
    list = testService.testSelectList();
    for(int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).toString());  
    }
    
    
    
    int cnt = 0;
    cnt = testService.testSelectListCnt();
    
    
    
    TestVO getVO = new TestVO();
    TestVO paramVO = new TestVO();
    paramVO.setUserId(userId);
    getVO = testService.testSelectListParam(paramVO);
    
    model.addAttribute("userId", getVO);
    model.addAttribute("cnt", cnt);
    model.addAttribute("list", list); 
    return "/test";
  }
  
}
