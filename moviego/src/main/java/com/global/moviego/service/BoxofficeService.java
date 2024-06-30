package com.global.moviego.service;

import com.global.moviego.domain.BoxofficeVO;
import java.util.List;

public interface BoxofficeService {
    List<BoxofficeVO> getWeeklyBoxOffice();
}
