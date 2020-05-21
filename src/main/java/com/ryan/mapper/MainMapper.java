package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.HashtagVO;
import com.ryan.domain.main.FilterSearchVO;
import com.ryan.domain.main.KeywordAutoCompletionVO;
import com.ryan.domain.member.MemberVO;

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
	
	//해시태그 랜덤으로 가져오기
	public ArrayList<HashtagVO> getRandomHashTag();
	
	//해시태그로 추천
	public ArrayList<EBookVO> getHashTagBook(ArrayList<HashtagVO> hashTagList);
	
	/////////////////////////////////////
	
	//검색기능 자동완성
	public ArrayList<KeywordAutoCompletionVO> getAutoKeyword(@Param("type") String type , @Param("keyword") String keyoword);
	//타이틀 검색일경우 해시태그 가져오기
	public ArrayList<String> getAutoKeywordHashtag(int bookNum);
	
	//필터검색
	
	public ArrayList<EBookVO> getFilterSearch(FilterSearchVO filterSearch); 
	
	//관심
	public int[] getMemberInterests(@Param("memberEmail") String memberEmail);
	
	//비로그인시
	
	public int[] getSecondCategory();
	
	public ArrayList<EBookVO> getInterestsBook(int[] categoryArr);
	
	public ArrayList<EBookVO> getAlarmBook();
	
}
