package com.ryan.service.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;

public interface MainPageService {
	
	public ArrayList<EBookVO> getEbookList(String type, String[] keyword);
	
	public ArrayList<EBookVO> getBookList(String type, String[] keyword);
	
}
