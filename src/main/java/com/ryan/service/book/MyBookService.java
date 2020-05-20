package com.ryan.service.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.member.MemberVO;

public interface MyBookService {

	//찜 책장 -- 조회, 삭제 입력
	public ArrayList<EBookVO> libBook(String clickId,HttpSession session);
	
	public ArrayList<EBookVO> deleteLibBook(int[] booknum, HttpServletRequest request);
	
	public Boolean insertLibBook(int booknumber, HttpSession session);
	
	public int countLibBook(String clickId,HttpSession session);
	
	
	//읽고있는 책
	public ArrayList<EBookVO>  readBook(String clickId,HttpSession session);
	
	//읽고있는 책 삭제
	public ArrayList<EBookVO> deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public Boolean insertReadBook(int booknumber, HttpServletRequest request);

	public int countReadBook(String clickId,HttpSession session);
	
	public int countLikeBook(String clickId,HttpSession session);
	
	
	//평점 등록
	public ArrayList<BookGradeVO> insertGrade(BookGradeVO vo, HttpSession session);
	
	//개인정보조회
	public MemberVO readClickId(String clickId);

}
