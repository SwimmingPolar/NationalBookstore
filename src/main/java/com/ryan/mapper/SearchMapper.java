package com.ryan.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;

public interface SearchMapper {
	public ArrayList<EBookVO> ebookList(String type,@Param("keyword") String[] keyword);
	
	public ArrayList<EBookVO> bookList(String type,@Param("keyword") String[] keyword);
	////////////////////////////////이 아래로 제가 수정 좀 했습니다.
	//ebook 검색
	public List<EBookVO> searchEbook(@Param("type") String type, @Param("keyword") String[] keyword);
	//종이책 검색
	public List<EBookVO> searchPaperbook(@Param("type") String type, @Param("keyword") String[] keyword);
	//ebook 페이징
	public List<EBookVO> searchEbookPage(@Param("type") String type,@Param("keyword") String[] keyword, @Param("pageNum") int pageNum);
	//종이책 페이징
	public List<EBookVO> searchPaperbookPage(@Param("type") String type,@Param("keyword") String[] keyword, @Param("pageNum") int pageNum);
	//전체 책.
	public List<EBookVO> getFilterSearch(@Param("genre") String genre, @Param("sub_genre") String sub_genre, @Param("page") String page, @Param("sort") String sort );
	//전체 책 갯수.
	public List<EBookVO> getFilterSearchCount(@Param("genre") String genre, @Param("sub_genre") String sub_genre, @Param("page") String page );
}
