package com.admin.service.event;

import java.util.ArrayList;

import com.admin.domain.book.AdminBestListVO;

public interface AdminEventService {
	
	public Boolean pushBook(AdminBestListVO booknum);		//추천책 등록
	
	public Boolean deleteBook(int[] deletenum);							//삭제
	
}
