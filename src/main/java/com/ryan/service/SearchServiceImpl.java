package com.ryan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.EBookVO;
import com.ryan.mapper.SearchMapper;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchMapper mapper;

	@Override
	public ArrayList<EBookVO> searchBookM(String[] temp) {
		ArrayList <EBookVO> vo=new ArrayList <EBookVO>();
		vo.add(mapper.searchBook(temp));
		return vo;
	}
	
	
}
