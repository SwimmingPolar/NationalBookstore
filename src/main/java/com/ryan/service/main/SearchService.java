package com.ryan.service.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;

public interface SearchService {
	//검색결과 책리스트
	public ArrayList<EBookVO> bookList(String type,String [] keyword);
	
	//검색한 결과중 현물책 리스트
	public  ArrayList<EBookVO> ebookList(String type,String [] keyword);
	

	//e북이나 현물북의 페이지 요청이 있을시 페이지 번호를 받고 해당 페이지 북리스트를 넘긴다
	public  ArrayList<EBookVO> pageList(ArrayList<EBookVO> tmpList,int pageNum);


	/////////////////////////////////////이 아래로 제가 수정좀 했습니다.
	//전체 책.
	public List<EBookVO> getFilterSearch(@Param("genre") String genre, @Param("sub_genre") String sub_genre, @Param("page") String page, @Param("sort") String sort );
	//전체 책 갯수.
	public List<EBookVO> getFilterSearchCount(@Param("genre") String genre, @Param("sub_genre") String sub_genre, @Param("page") String page );
	//ebook
	public List<EBookVO> ebook(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page);
	//paper
	public List<EBookVO> paper(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page);
	//count
	public List<EBookVO> ebookCount(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page);
	public List<EBookVO> paperCount(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page);
	//장르별 종이책 검색
	public List<EBookVO> getPaperByGenre(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page, @Param("genre") String genre);
	//장르별 종이책 검색 count
	public List<EBookVO> getPaperByGenreCount(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page, @Param("genre") String genre);
	//asd
	public List<HashMap<String, String>> getGenreCount(@Param("type") String type, @Param("keyword") String[] keyword, @Param("page") String page, @Param("genre") String genre);
}
