package com.ryan.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ryan.domain.EBookVO;
import com.ryan.domain.PageVO;

public interface SearchService {
	public ArrayList<EBookVO> searchBookM(String writer,String bookname);
	
	public ArrayList<PageVO> paging(PageVO pageInfo);
	
	/////////////////////////////////////이 아래로 제가 수정좀 했습니다.
	//ebook 검색
	public List<EBookVO> searchEbook(String type, String[] keyword) throws ClassNotFoundException, SQLException;
	//종이책 검색
	public List<EBookVO> searchPaperbook(String type, String[] keyword) throws ClassNotFoundException, SQLException;

	
}
