package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;

public interface MainMapper {
	
	public ArrayList<EBookVO> getEbookList(@Param("type") String type, @Param("keyword") String[] keyword);
	
	public ArrayList<EBookVO> getBookList(@Param("type") String type, @Param("keyword") String[] keyword);
	
	//메인페이지 데이터
	
	//오늘의 추천 도서
	public ArrayList<EBookVO> getTodayBookList();
	
	//해시태그 추천 (구상중)
	
	//사람들이 많이 읽은 책
	public ArrayList<EBookVO> getBestReadBook();
	
	//베스트셀러
	public ArrayList<EBookVO> getBestSeller(@Param("time") String time , @Param("category") String category);
	
	//세일
	public ArrayList<EBookVO> getDisCountBook();
	
	
	
}
