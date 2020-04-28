package com.ryan.service.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;

public interface MyBookService {

	//찜 책장 -- 조회, 삭제 입력
	public List<MyLibVO> libBook(MyLibVO vo);
	
	public List<MyLibVO> deleteLibBook(MyLibVO vo);
	
	public Boolean insertLibBook(MyLibVO vo);
	
	//읽고있는 책
	public List<MyReadBookVO>  readBook(MyReadBookVO vo);
	
	//읽고있는 책 삭제
	public List<MyReadBookVO> deleteReadBook(MyReadBookVO vo);
	
	//읽고있는 책
	public Boolean insertReadBook(int booknumber, MyReadBookVO vo);


}
