package com.global.moviego.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SampleMapper {

    public List<Map<String, Object>> selectSampleList(Map<String, Object> paramMap);
  
}
