package com.ryan.service;

import javax.servlet.http.HttpServletRequest;

public interface InterestsService {
	
	//관심 등록
	public boolean insertInterests(int[] categoryArray, HttpServletRequest request);
		
	
}
