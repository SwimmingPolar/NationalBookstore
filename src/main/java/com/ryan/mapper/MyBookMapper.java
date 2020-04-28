package com.ryan.mapper;


import java.util.List;

import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;

public interface MyBookMapper {
	
	//찜 책장 -- 조회, 삭제 입력
	public List<MyLibVO> libBook(String memberemail);
	
	public int deleteLibBook(MyLibVO vo);
	
	public int insertLibBook(MyLibVO vo);
	
	//읽고있는 책
	public List<MyReadBookVO> readBook(String memberemail);
	
	//읽고있는 책 삭제
	public int deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public int insertReadBook(MyReadBookVO vo);
	
	//책이 이미 존재하면 읽은시간 업데이트
	public int updateReadBook(MyReadBookVO vo);
}
