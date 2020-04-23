package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.MyLibVO;
import com.ryan.domain.MyReadBookVO;

public interface MyBookMapper {
	
	//책장
	public ArrayList<MyLibVO> readingBook(MyLibVO vo);
	
	public int deleteList(MyLibVO vo);
	
	public int insertList(MyLibVO vo);
	
	
	//읽고있는 책
	public int insertReadBook(MyReadBookVO vo);
	
	public int updateReadBook(MyReadBookVO vo);
	
	public ArrayList<MyReadBookVO> readBookList(MyReadBookVO vo);
	
	public int deleteReadBook(MyReadBookVO vo);
}
