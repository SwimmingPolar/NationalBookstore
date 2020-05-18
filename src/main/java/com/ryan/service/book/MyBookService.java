package com.ryan.service.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;

public interface MyBookService {

	//찜 책장 -- 조회, 삭제 입력
	public ArrayList<EBookVO> libBook(HttpSession session);
	
	public ArrayList<EBookVO> deleteLibBook(int[] booknum, HttpSession session);
	
	public Boolean insertLibBook(int booknumber, HttpSession session);
	
	public int countLibBook(HttpSession session);
	
	
	//읽고있는 책
	public ArrayList<EBookVO>  readBook(HttpSession session);
	
	//읽고있는 책 삭제
	public ArrayList<EBookVO> deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public Boolean insertReadBook(MyReadBookVO vo, HttpServletRequest request);

	public int countReadBook(HttpSession session);
	
	public int countLikeBook(HttpSession session);
	
	
	//평점 등록
	public ArrayList<BookGradeVO> insertGrade(BookGradeVO vo, HttpSession session);
	

}
