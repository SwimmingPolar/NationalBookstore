package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.MyLibVO;

public interface MyBookMapper {
	
	public ArrayList<MyLibVO> readingBook(MyLibVO vo);
	
	public int deleteList(MyLibVO vo);
	
	public int insertList(MyLibVO vo);
}
