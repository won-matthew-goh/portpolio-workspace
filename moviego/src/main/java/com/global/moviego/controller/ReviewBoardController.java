package com.global.moviego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.global.moviego.domain.PageCreate;
import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.service.ReviewBoardServiceImpl;

@Controller
@RequestMapping("/review")

public class ReviewBoardController {
	@Autowired
	private ReviewBoardServiceImpl reviewBoardService;

	// 게시글 리스트 출력 및 10개씩 페이징
	@GetMapping("")
	public String reviewList(Model model, PageVO vo) {
		// 페이지 수 만큼 10개씩 노출
		List<ReviewBoardVO> pageList = reviewBoardService.getFreeBoard();
		model.addAttribute("list", pageList);
		//jsp에 pageCreate PageVo, articleTotalCount, endPage, beginPage, prev, next 정보 전송
		model.addAttribute("pageMaker", new PageCreate());
		
		return "board/list";
	}

	// 게시글 작성 페이지
	@GetMapping("/new")
	public String createBoard() {
		return "board/new";
	}

	@PostMapping("/new")
	public String register(ReviewBoardVO vo, RedirectAttributes rttr) {
		reviewBoardService.register(vo);
		return "redirect:/review";
	}

	// 게시글 읽기 페이지
	@GetMapping("/read")
	public String readBoard() {
		return "board/read";
	}

	
	
	
	
	
	
	
	
//페이징 기존 작성 코드(보류)	
//	@GetMapping("")
//	public String reviewList(Model model, PageVO vo) {
//		if (vo.getPageNum() == 0) {
//			vo.setPageNum(1);
//		}
//		if (vo.getCountPerPage() == 0) {
//			vo.setCountPerPage(10); // 페이지 당 기본 항목 수 설정
//		}
//		// 페이지 수 만큼 10개씩 노출
//		List<ReviewBoardVO> pageList = reviewBoardService.getFreeBoard();
//		model.addAttribute("list", pageList);
//
//		// 게시물 전체 숫자 DB 카운트 후 total에 담기 ex.총 10개 total 조회후 10 나누기 + 반올림 후 +1
//		int total = reviewBoardService.getTotal(vo);
//
//		int pageCountResult = (int) Math.ceil((total / vo.getCountPerPage()) + 1);
//		// 11.0 값 나옴
//
//		int pageCount = (int) Math.ceil(total / vo.getCountPerPage());
//		int startPage = (int) pageCountResult - pageCount;
//		int endPage = (int) pageCount;
//
//		Map<String, Object> getPageLength = new HashMap<>();
//		List<Integer> pageNumbers = new ArrayList<>();
//
//		for (int i = 1; i <= endPage; i++) {
//			pageNumbers.add(i);
//		}
//
//		getPageLength.put("pages", pageNumbers);
	
}
