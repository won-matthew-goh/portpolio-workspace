package com.global.moviego.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.domain.TestVO;
import com.global.moviego.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  private TestMapper testMapper;
  @Override
  public List<TestVO> testSelectList() {
    List<TestVO> list = new ArrayList<TestVO>();
    list = testMapper.selectTest();
    return list;
  }
  @Override
  public int testSelectListCnt() {
    int cnt = 0;
    cnt = testMapper.selectTestCnt();
    return cnt;
  }
  @Override
  public TestVO testSelectListParam(TestVO paramVO) {
    TestVO returnVO = new TestVO();
    returnVO = testMapper.selectTestParam(paramVO);
    return returnVO;
  }
  
}
