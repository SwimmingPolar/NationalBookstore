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
}
