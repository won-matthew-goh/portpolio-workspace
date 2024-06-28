package com.global.moviego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.global.moviego.domain.TestVO;

@Repository
@Mapper
public interface TestMapper {

    public List<TestVO> selectTest();
    
    public int selectTestCnt();
    
    public TestVO selectTestParam(TestVO testVO);
  
}
