package com.global.moviego.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.global.moviego.domain.PageCreate;
import com.global.moviego.domain.PageVO;
import com.global.moviego.domain.ReviewBoardVO;
import com.global.moviego.domain.UserVO;
import com.global.moviego.mapper.ReviewBoardMapper;
import com.global.moviego.mapper.UserMapper;
import com.global.moviego.service.ReviewBoardServiceImpl;
import com.global.moviego.service.SearchServiceImpl;
import com.global.moviego.service.UserService;

@Controller
@RequestMapping("/review")
public class ReviewBoardController {

  @Autowired
  private MessageSource messageSource;

  @Autowired
  private ReviewBoardServiceImpl reviewBoardService;

  @Autowired
  SearchServiceImpl searchService;

  @Autowired
  UserService userService;
  
  @Autowired
  UserMapper userMapper;

  @Value("${poster.tmdb.url}")
  private String imageApiUrl;

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
  public String reviewList(Model model, @ModelAttribute PageVO vo, ReviewBoardVO reviewboardvo, Locale locale) {
    if (vo.getPageNum() == 0) {
      vo.setPageNum(1);
    }
    if (vo.getCountPerPage() == 0) {
      vo.setCountPerPage(10);
    }

    // 페이지 offset 계산
    vo.setOffset((vo.getPageNum() - 1) * vo.getCountPerPage());

    List<ReviewBoardVO> pageList = reviewBoardService.getBoard(vo);

    for (ReviewBoardVO review : pageList) {
      review.setMovieNm(getLocalizedMovieTitle(review, locale));
    }

    model.addAttribute("list", pageList);

    // 페이징 처리
    int articleTotalCount = reviewBoardService.getTotal(vo);
    vo.setTotal(articleTotalCount);

    PageCreate pageCreate = new PageCreate(articleTotalCount, vo);
    model.addAttribute("pageMaker", pageCreate);

    return "board/list";
  }

//  private String getLocalizedMovieTitle(ReviewBoardVO review, Locale locale) {
//    if (locale.getLanguage().equals("en")) {
//      return StringUtils.hasText(review.getMovieNmEn()) ? review.getMovieNmEn() : review.getMovieNm();
//    } else if (locale.getLanguage().equals("ja")) {
//      return StringUtils.hasText(review.getMovieNmJa()) ? review.getMovieNmJa() : review.getMovieNm();
//    }
//    return review.getMovieNm();
//  }

  private String getLocalizedMovieTitle(ReviewBoardVO review, Locale locale) {
    if (locale.getLanguage().equals("en")) {
      return review.getMovieNmEn() != null && !review.getMovieNmEn().isEmpty() ? review.getMovieNmEn()
          : review.getMovieNm();
    } else if (locale.getLanguage().equals("ja")) {
      return review.getMovieNmJa() != null && !review.getMovieNmJa().isEmpty() ? review.getMovieNmJa()
          : review.getMovieNm();
    }
    return review.getMovieNm();
  }

  // 게시글 작성 페이지
  @GetMapping("/new")
  public String createBoard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
    if (userDetails != null) {
      String username = userDetails.getUsername();
      model.addAttribute("username", username);
    }
    return "board/new";
  }

  @PostMapping("/new")
  public String register(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute ReviewBoardVO vo,
      RedirectAttributes rttr) {
    if (userDetails != null) {
      String username = userDetails.getUsername();
      UserVO user = userService.getUserByUsername(username);

      // Long을 int로 변환
      Long userIdLong = user.getUserId();

      // int 범위를 초과하는지 확인
      if (userIdLong > Integer.MAX_VALUE) {
        rttr.addFlashAttribute("errorMessage", "사용자 ID가 너무 큽니다.");
        return "redirect:/error";
      }

      int userIdInt = userIdLong.intValue();
      vo.setUserId(userIdInt);
      vo.setUsername(username);

      reviewBoardService.register(vo);
      return "redirect:/review";
    } else {
      rttr.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
      return "redirect:/login";
    }
  }

  // 게시글 읽기 페이지
  @GetMapping("/read")
  public String readBoard(@RequestParam("reviewId") int reviewId, Model model, @AuthenticationPrincipal UserDetails userDetails) {
      // 기존 코드...
      ReviewBoardVO board = reviewBoardService.getBoardById(reviewId);
      model.addAttribute("board", board);
   // 조회수 증가
  	reviewBoardService.incrementReadCount(reviewId);
      if (userDetails != null) {
          UserVO currentUser = userMapper.findByUsername(userDetails.getUsername());
          model.addAttribute("currentUser", currentUser);
      }

      return "board/read";
  }

  // 게시글 수정 페이지로 이동
  @GetMapping("/edit")
  public String editBoard(@RequestParam("reviewId") int reviewId, Model model) {
    ReviewBoardVO board = reviewBoardService.getBoardById(reviewId);
    board.setMovieNm(board.getMovieNm());
    System.out.println(board.getMovieNm());
    model.addAttribute("board", board);
    return "board/new"; // 기존의 글쓰기 화면을 활용
  }

  // 게시글 수정
  @PostMapping("/edit")
  public String updateBoard(@ModelAttribute ReviewBoardVO vo, RedirectAttributes rttr) {
    reviewBoardService.updateBoard(vo);
    return "redirect:/review/list";
  }

  // 게시글 삭제
  @PostMapping("/delete")
  public String deleteBoard(@RequestParam("reviewId") int reviewId, RedirectAttributes rttr) {
    reviewBoardService.deleteBoard(reviewId);
    return "redirect:/review/list";
  }

  // 게시글 신고하기
  @PostMapping("/report")
  public String reportReview(@RequestParam("reviewId") int reviewId, RedirectAttributes rttr) {
    reviewBoardService.incrementReportCount(reviewId);
    return "redirect:/review";
  }

  @GetMapping("/list")
  public String listReviews(Model model, @ModelAttribute PageVO vo) {
    if (vo.getPageNum() == 0) {
      vo.setPageNum(1);
    }
    if (vo.getCountPerPage() == 0) {
      vo.setCountPerPage(10);
    }

    vo.setOffset((vo.getPageNum() - 1) * vo.getCountPerPage());

    List<ReviewBoardVO> pageList = reviewBoardService.getBoard(vo);
    model.addAttribute("list", pageList);

    int articleTotalCount = reviewBoardService.getTotal(vo);
    vo.setTotal(articleTotalCount);

    PageCreate pageCreate = new PageCreate(articleTotalCount, vo);
    model.addAttribute("pageMaker", pageCreate);

    return "board/list";
  }

}