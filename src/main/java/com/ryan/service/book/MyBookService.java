package com.ryan.service.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.member.MemberVO;

public interface MyBookService {

	//찜 책장 -- 조회, 삭제 입력
	public ArrayList<EBookVO> libBook(String clickId,Authentication auth);
	
	public ArrayList<EBookVO> deleteLibBook(int[] booknum, HttpServletRequest request, Authentication auth);
	
	public Boolean insertLibBook(int booknumber, Authentication auth);
	
	public int countLibBook(String clickId,Authentication auth);
	
	
	//읽고있는 책
	public ArrayList<EBookVO>  readBook(String clickId,Authentication auth);
	
	//읽고있는 책 삭제
	public ArrayList<EBookVO> deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public Boolean insertReadBook(int booknumber, Authentication auth);

	public int countReadBook(String clickId,Authentication auth);
	
	public int countLikeBook(String clickId,Authentication auth);
	
	
	//평점 등록
	public ArrayList<BookGradeVO> insertGrade(BookGradeVO vo, Authentication auth);
	
	//개인정보조회
	public MemberVO readClickId(String clickId);
	
	//팔로우 되어 있는지 확인
	public Boolean followCheck(String clickId);

}
