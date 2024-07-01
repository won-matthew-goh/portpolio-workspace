package com.global.moviego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.moviego.service.ReviewBoardService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/review")

public class ReviewBoardController {
	@Autowired
	private ReviewBoardService reviewBoardService;
	
	@GetMapping("/")//DB에 저장된 게시글 리스트를 출력
	public String boardList() {
		return "board";
	}
	
	
	@GetMapping("/new")//게시글 작성 폼 노출 후 입력 값을 DB로 저장, 저장 후 게시글 목록으로 이동
	public String boardNew() {
		return "new";
	}
	
	@GetMapping("/read")//게시글 목록에서 클릭 시 입력되어 있던 정보를 DB에서 호출해서 노출(영화 포스터틑 API에서)
	public String boardRead() {
		return "read";
	}
}
