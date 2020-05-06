package com.admin.mapper;

import java.util.List;
import java.util.Map;

import com.admin.domain.AdminBestListVO;

public interface AdminEventMapper {
	
	public int pushBook(AdminBestListVO vo);		//추천책 등록
	
	public int countBook();							//추천책 등록된 수
	
	public List<AdminBestListVO> checkBook(); 		//중복확인
	
	public int deleteBook(Map list);				//삭제

}
