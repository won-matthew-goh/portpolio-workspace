package com.global.moviego.service;

import java.util.Map;

public interface SampleService {

	/**
	 * VO 안쓰고 Map으로 샘플 서비스
	 * @param  Map<String, Object> paramMap
	 * @return Map<String, Object>
	 */
	public Map<String, Object> selectSampleList(Map<String, Object> paramMap);
  
}
