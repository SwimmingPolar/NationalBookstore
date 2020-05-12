package com.ryan.service.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;

public interface MainPageService {
	
	public ArrayList<EBookVO> getEbookList(String type, String[] keyword);
	
	public ArrayList<EBookVO> getBookList(String type, String[] keyword);
	
	//오늘의 추천 도서
	public ArrayList<EBookVO> getTodayBookList();
	
	//해시태그 추천 (구상중)
	
	//사람들이 많이 읽은 책
	public ArrayList<EBookVO> getBestReadBook();
	
}
