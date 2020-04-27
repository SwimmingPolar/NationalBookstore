package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.EBookVO;

public interface MainMapper {
	
	public ArrayList<EBookVO> getEbookList(@Param("type") String type, @Param("keyword") String[] keyword);
	
	public ArrayList<EBookVO> getBookList(@Param("type") String type, @Param("keyword") String[] keyword);
	
}
