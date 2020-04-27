package com.ryan.service;

import java.util.ArrayList;

import com.ryan.domain.EBookVO;
import com.ryan.domain.PageVO;

public interface SearchService {
	public ArrayList<EBookVO> searchBookM(String writer,String bookname);
	
	public ArrayList<PageVO> paging(PageVO pageInfo);
	
}
