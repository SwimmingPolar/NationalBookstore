package com.ryan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.EBookVO;
import com.ryan.domain.PageVO;
import com.ryan.mapper.SearchMapper;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchMapper mapper;

	@Override
	public ArrayList<EBookVO> searchBookM(String writer,String bookname) {
		ArrayList <EBookVO> vo=new ArrayList <EBookVO>();
		
		if(writer.length()==0 && bookname.length()==0) {
			
		}else if(writer.length()>0) {
			String [] w=writer.split("\\s+");
			vo.add(mapper.typeWriter(w));
		}else if(bookname.length()>0) {
			String [] bn=bookname.split("\\s+");
			vo.add(mapper.typeWriter(bn));
		}
		return vo;
	}

	@Override
	public ArrayList<PageVO> paging(PageVO pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}
}
