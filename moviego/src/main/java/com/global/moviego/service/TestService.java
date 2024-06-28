package com.global.moviego.service;

import java.util.List;
import java.util.Map;

import com.global.moviego.domain.TestVO;

public interface TestService {

  public List<TestVO> testSelectList();
  
  public int testSelectListCnt();
  
  public TestVO testSelectListParam(TestVO paramVO);
  
}
