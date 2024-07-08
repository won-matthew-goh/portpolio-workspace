package com.global.moviego.service;

import java.util.List;
import com.global.moviego.domain.MovieUpcommingVO;
import jakarta.servlet.http.HttpServletRequest;

public interface HomeService {
    List<MovieUpcommingVO> movieUpcommingList(HttpServletRequest request);
}