package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.BookCategoryVO;

public interface BookCategoryMapper {
	
	//카테고리 목록들 출력
	public ArrayList<BookCategoryVO> getBookCategoryList();
	
}
