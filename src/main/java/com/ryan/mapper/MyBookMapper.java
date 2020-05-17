package com.ryan.mapper;


import java.util.ArrayList;
import java.util.Map;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;

public interface MyBookMapper {
	
	//찜 책장 -- 조회, 삭제 입력
	public ArrayList<EBookVO> libBook(String memberemail);
	
	public int deleteLibBook(Map list);
	
	public int insertLibBook(MyLibVO vo);
	
	public int countLibBook(String memberemail);
	
	
	//읽고있는 책
	public ArrayList<EBookVO> readBook(String memberemail);
	
	//읽고있는 책 삭제
	public int deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public int insertReadBook(MyReadBookVO vo);
	
	//책이 이미 존재하면 읽은시간 업데이트
	public int updateReadBook(MyReadBookVO vo);
	
	public int countReadBook(String memberemail);
	
	
	public int countLikeBook(String memberemail);
	
	
	//평점 등록
	public ArrayList<BookGradeVO> insertGrade(BookGradeVO vo);
	
	//평점 등록 확인
	public ArrayList<BookGradeVO> checkEmail(String email);
}
