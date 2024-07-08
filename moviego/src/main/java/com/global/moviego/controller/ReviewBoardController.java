package com.global.moviego.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.global.moviego.domain.PageCreate;
import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.service.ReviewBoardServiceImpl;
import com.global.moviego.service.SearchServiceImpl;

@Controller
@RequestMapping("/review")
public class ReviewBoardController {
	
  @Autowired
	private ReviewBoardServiceImpl reviewBoardService;


	@Autowired
	SearchServiceImpl searchService;
	 // 검색 요청 처리
    @GetMapping("/search")
    public String search(@RequestParam Map<String, Object> paramMap, Model model, PageVO vo) {
        if (vo.getPageNum() == 0) {
            vo.setPageNum(1);
        }
        if (vo.getCountPerPage() == 0) {
            vo.setCountPerPage(10);
        }

        // 페이지 offset 계산
        vo.setOffset((vo.getPageNum() - 1) * vo.getCountPerPage());

        // paramMap에 offset과 countPerPage 추가
        paramMap.put("offset", vo.getOffset());
        paramMap.put("countPerPage", vo.getCountPerPage());

        Map<String, Object> searchResults = searchService.getReviewSearch(paramMap);
        model.addAttribute("list", searchResults.get("results"));

        // 검색 후 페이징 처리
        int articleTotalCount = searchService.getReviewSearchTotal(paramMap);
        vo.setTotal(articleTotalCount);
        PageCreate pageCreate = new PageCreate(articleTotalCount, vo);
        model.addAttribute("pageMaker", pageCreate);
		return "board/list";
	}	

	// 게시글 리스트 출력 및 10개씩 페이징
	@GetMapping("")
	public String reviewList(Model model, @ModelAttribute PageVO vo) {
		if (vo.getPageNum() == 0) {
			vo.setPageNum(1);
		}
		if (vo.getCountPerPage() == 0) {
			vo.setCountPerPage(10);
		}

		// 페이지 offset 계산
		vo.setOffset((vo.getPageNum() - 1) * vo.getCountPerPage());

		List<ReviewBoardVO> pageList = reviewBoardService.getBoard(vo);
		model.addAttribute("list", pageList);

		// 페이징 처리
		int articleTotalCount = reviewBoardService.getTotal(vo);
		vo.setTotal(articleTotalCount);

		PageCreate pageCreate = new PageCreate(articleTotalCount, vo);
		model.addAttribute("pageMaker", pageCreate);

		return "board/list";
	}

	// 게시글 작성 페이지
	@GetMapping("/new")
	public String createBoard() {
		return "board/new";
	}

	@PostMapping("/new")
	public String register(@ModelAttribute ReviewBoardVO vo, RedirectAttributes rttr) {
		reviewBoardService.register(vo);
		return "redirect:/review";
	}

	// 게시글 읽기 페이지
	@GetMapping("/read")
	public String readBoard(@RequestParam("reviewId") int reviewId, Model model) {
		ReviewBoardVO board = reviewBoardService.getBoardById(reviewId);
		model.addAttribute("board", board);
		return "board/read";
	}

	// 게시글 수정 페이지로 이동
	@GetMapping("/edit")
	public String editBoard(@RequestParam("reviewId") int reviewId, Model model) {
		ReviewBoardVO board = reviewBoardService.getBoardById(reviewId);
		model.addAttribute("board", board);
		return "board/new"; // 기존의 글쓰기 화면을 활용
	}

	// 게시글 수정
	@PostMapping("/edit")
	public String updateBoard(@ModelAttribute ReviewBoardVO vo, RedirectAttributes rttr) {
		reviewBoardService.updateBoard(vo);
		return "redirect:/review/read?reviewId=" + vo.getReviewId();
	}

	// 게시글 삭제
	@PostMapping("/delete")
	public String deleteBoard(@RequestParam("reviewId") int reviewId, RedirectAttributes rttr) {
		reviewBoardService.deleteBoard(reviewId);
		return "redirect:/review";
	}