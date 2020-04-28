package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.MyLibVO;
import com.ryan.domain.MyReadBookVO;

public interface MyBookService {

	//책장 -- 조회, 삭제 입력
	public ArrayList<MyLibVO> readingBook(MyLibVO vo, HttpServletRequest request);
	
	public ArrayList<MyLibVO> deleteList(MyLibVO vo);
	
	public boolean insertList(MyLibVO vo);
	
	
	
	//읽고있는 책
	public int insertReadBook(MyReadBookVO vo);
	
	public ArrayList<MyReadBookVO> readBookList(MyReadBookVO vo);
	
	public ArrayList<MyReadBookVO> deleteReadBook(MyReadBookVO vo);
}
