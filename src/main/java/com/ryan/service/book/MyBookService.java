package com.ryan.service.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;

public interface MyBookService {

	//찜 책장 -- 조회, 삭제 입력
	public List<EBookVO> libBook(HttpSession session);
	
	public List<EBookVO> deleteLibBook(MyLibVO vo);
	
	public Boolean insertLibBook(MyLibVO vo);
	
	public int countLibBook(HttpSession session);
	
	
	//읽고있는 책
	public List<MyReadBookVO>  readBook(HttpSession session);
	
	//읽고있는 책 삭제
	public List<MyReadBookVO> deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public Boolean insertReadBook(MyReadBookVO vo, HttpServletRequest request);

	public int countReadBook(HttpSession session);
	

}
