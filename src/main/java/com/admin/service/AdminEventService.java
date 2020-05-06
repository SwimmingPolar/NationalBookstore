package com.admin.service;

import java.util.ArrayList;

import com.admin.domain.AdminBestListVO;

public interface AdminEventService {
	
	public Boolean pushBook(ArrayList<AdminBestListVO> booknum);		//추천책 등록
	
	public Boolean deleteBook(int[] deletenum);							//삭제
}
