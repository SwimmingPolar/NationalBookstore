package com.ryan.mapper;

import java.util.ArrayList;


import com.ryan.domain.book.SecondCategoryVO;

public interface BookCategoryMapper {
	
	//카테고리 목록들 출력
	public ArrayList<SecondCategoryVO> getBookCategoryList();
	
}
