package com.global.moviego.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@GetMapping("/sample/sampleMapParam")
	public String sampleMapParam(Model model, @RequestParam Map<String, Object> paramMap) {
		System.out.println("@@ START @@");
		
		// VO 없이 파라미터를 편하게 받을수있음.
		System.out.println("paramMap.toString() : " + paramMap.toString());
		
		Map<String, Object> rtnMap = sampleService.selectSampleList(paramMap);
		System.out.println("rtnMap.toString()" + rtnMap.toString());
		
		model.addAttribute("data", rtnMap);
		
		
		System.out.println("@@ END @@");
		
		return "/sample/sample";
		
	}
	
	/**
	 * AJAX 데이터 호출
	 * @param model
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("/sample/sampleAjax")
	public @ResponseBody Map<String, Object> sampleAjax(Model model, @RequestParam Map<String, Object> paramMap) {
		System.out.println("@@ sampleAjax START @@");
		
		Map<String, Object> rtnMap    = new HashMap<String, Object>();
		
		Map<String, Object> getUsrMap = new HashMap<String, Object>();
		getUsrMap = sampleService.selectSampleList(paramMap);
		rtnMap.put("userData", getUsrMap);
		
		System.out.println("@@ sampleAjax END @@");
		
		return rtnMap;
		
	}
  
}
