package com.ryan.service;

import java.util.ArrayList;

import com.ryan.domain.MyLibVO;

public interface MyBookService {

	public ArrayList<MyLibVO> readingBook(MyLibVO vo);
	
	public ArrayList<MyLibVO> deleteList(MyLibVO vo);
	
	public boolean insertList(MyLibVO vo);
}
