package com.ryan.service.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.EBookVO;
import com.ryan.mapper.SearchMapper;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchMapper mapper;
	
	@Override
	public ArrayList<EBookVO> bookList(String type, String[] keyword) {
		return mapper.bookList(type, keyword);
	}


	@Override
	public ArrayList<EBookVO> ebookList(String type, String[] keyword) {
		return mapper.ebookList(type, keyword);
	}
	
	@Override
	public ArrayList<EBookVO> pageList(ArrayList<EBookVO> tmpList,int pageNum) {
		ArrayList<EBookVO> pagevo=new ArrayList<EBookVO>();
		
		int start=1;
		int end=0;
		
		start=((pageNum-1)*12)+1;
		
		if(pageNum*12 <= tmpList.size()) 
			end=pageNum*12;
		else {
			end=tmpList.size();
		}
		
		for(int i=start;i<=end;i++) {
			pagevo.add(tmpList.get(i));
		}
		
		return pagevo;
	}
	
	/////////////////////////////////////이 아래로 제가 수정좀 했습니다.
	//전체 책.
	@Override
	public List<EBookVO> getFilterSearch(String genre, String sub_genre, String page, String sort) {
		return mapper.getFilterSearch(genre, sub_genre, page, sort);
	}
	//전체 책 갯수.
	@Override
	public List<EBookVO> getFilterSearchCount(String genre, String sub_genre, String page) {
		return mapper.getFilterSearchCount(genre, sub_genre, page);
	}
	//ebook
	@Override
	public List<EBookVO> ebook(String type, String[] keyword, String page) {
		return mapper.ebook(type, keyword, page);
	}
	//paper
	@Override
	public List<EBookVO> paper(String type, String[] keyword, String page) {
		return mapper.paper(type, keyword, page);
	}
	//count
	@Override
	public List<EBookVO> ebookCount(String type, String[] keyword, String page) {
		return mapper.ebookCount(type, keyword, page);
	}
	@Override
	public List<EBookVO> paperCount(String type, String[] keyword, String page) {
		return mapper.paperCount(type, keyword, page);
	}
}
