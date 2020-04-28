package com.ryan.service.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.EBookVO;
import com.ryan.mapper.MainMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MainPageServiceImpl implements MainPageService {
	
	@Setter(onMethod_ = {@Autowired})
	private MainMapper mapper;
	
	@Override
	public ArrayList<EBookVO> getEbookList(String type, String[] keyword) {
		return mapper.getEbookList(type, keyword);
	}

	@Override
	public ArrayList<EBookVO> getBookList(String type, String[] keyword) {
		return mapper.getBookList(type, keyword);
	}
	
	
	
}
