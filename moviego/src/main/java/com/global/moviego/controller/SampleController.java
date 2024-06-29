package com.global.moviego.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.service.SampleService;

@Controller
public class SampleController {
  
	@Autowired
	private SampleService sampleService;

	/**
	 * 파라미터 맵으로 받기 컨트롤러
	 * Service, Mapper까지 파라미터 Map으로 던지도록 샘플
	 * @param model
	 * @param paramMap
	 * @return
	 */
	@GetMapping("/sample/sample")
	public String test(Model model, @RequestParam Map<String, Object> paramMap) {
		System.out.println("@@ START @@");
		
		// VO 없이 파라미터를 편하게 받을수있음.
		System.out.println("paramMap.toString() : " + paramMap.toString());
		
		Map<String, Object> rtnMap = sampleService.selectSampleList(paramMap);
		System.out.println("rtnMap.toString()" + rtnMap.toString());
		
		model.addAttribute("data", rtnMap);
		
		
		System.out.println("@@ END @@");
		
		return "/sample/sample";
		
	}
  
}
