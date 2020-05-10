package com.ryan.service.book;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import com.ryan.domain.book.SecondCategoryVO;
import com.ryan.mapper.BookCategoryMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService {
	
	private BookCategoryMapper mapper;
	
	@Override
	public ArrayList<SecondCategoryVO> getBookCategory() {
		return mapper.getBookCategoryList();
	}

}
