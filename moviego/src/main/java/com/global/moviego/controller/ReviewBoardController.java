package com.global.moviego.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.service.ReviewBoardServiceImpl;

@Controller
@RequestMapping("/review")

public class ReviewBoardController {
	@Autowired
	private ReviewBoardServiceImpl reviewBoardService;

	// DB에 저장된 게시글 리스트 출력
	@GetMapping("")
	public String boardList(Model model) {
		List<ReviewBoardVO> list = new ArrayList<ReviewBoardVO>();
		list = reviewBoardService.selectReviewService();
		model.addAttribute("list", list);
		return "board";
	}

	@GetMapping("/new")
	public String createBoard() {
		return "new";
	}

	@PostMapping("/new")
	public String register(ReviewBoardVO vo, RedirectAttributes rttr) {

		rttr.addFlashAttribute("title", vo.getTitle());
		rttr.addFlashAttribute("rating", vo.getRating());
		rttr.addFlashAttribute("comment", vo.getComment());
		rttr.addFlashAttribute("createdAt", vo.getCreatedAt());
		reviewBoardService.register(vo);

		return "redirect:/review";

	}

}
