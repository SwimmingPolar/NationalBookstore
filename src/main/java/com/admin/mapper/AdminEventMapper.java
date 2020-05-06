package com.admin.mapper;

import java.util.List;

import com.admin.domain.AdminBestListVO;

public interface AdminEventMapper {
	
	public int pushBook(AdminBestListVO vo);
	
	public int countBook();
	
	public List<AdminBestListVO> checkBook();

}
