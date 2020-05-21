package com.ryan.service.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.main.FilterSearchVO;
import com.ryan.domain.main.KeywordAutoCompletionVO;
import com.ryan.domain.member.MemberVO;

public interface MainPageService {
	
	public ArrayList<EBookVO> getEbookList(String type, String[] keyword);
	
	public ArrayList<EBookVO> getBookList(String type, String[] keyword);
	
	//오늘의 추천 도서
	public ArrayList<EBookVO> getTodayBookList();
	
	//해시태그 추천 (구상중)
	
	//사람들이 많이 읽은 책
	public ArrayList<EBookVO> getBestReadBook();
	
	//베스트셀러
	public ArrayList<EBookVO> getBestSeller(@Param("time") String time , @Param("category") String category);
	
	//세일
	public ArrayList<EBookVO> getDisCountBook();
	
	public ArrayList<KeywordAutoCompletionVO> getAutoKeyword(String type ,String keyoword);
	
	//필터 예시
	public ArrayList<EBookVO> getFilterSearch(FilterSearchVO filterSearch); 
	
	public ArrayList<EBookVO> getinterests(MemberVO member);
	
}
