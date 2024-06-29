package com.global.moviego.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.moviego.mapper.SampleMapper;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;
	
	/**
	 * VO 안쓰고 Map으로 샘플 서비스
	 * @param  Map<String, Object> paramMap
	 * @return Map<String, Object>
	 */
	@Override
	public Map<String, Object> selectSampleList(Map<String, Object> paramMap) {
		Map<String, Object> returnMap  = new HashMap<String, Object>();			// return 할 맵 선언
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();	// 데이터 조회할 리스트맵 선언
		list = sampleMapper.selectSampleList(paramMap);							// 데이터 조회
		
		returnMap.put("list", list);											// return 할 맵에 담기
		
		return returnMap;
	}
 
}
