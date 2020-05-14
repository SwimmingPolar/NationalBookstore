package com.ryan.service.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.main.FilterSearchVO;
import com.ryan.domain.main.KeywordAutoCompletionVO;
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

	@Override
	public ArrayList<EBookVO> getTodayBookList() {
		return mapper.getTodayBookList();
	}

	@Override
	public ArrayList<EBookVO> getBestReadBook() {
		return mapper.getBestReadBook();
	}

	@Override
	public ArrayList<EBookVO> getFilterSearch(FilterSearchVO filterSearch) {
		return mapper.getFilterSearch(filterSearch);
	}

	@Override
	public ArrayList<EBookVO> getBestSeller(String time, String category) {
		return mapper.getBestSeller(time, category);
	}

	@Override
	public ArrayList<EBookVO> getDisCountBook() {
		return mapper.getDisCountBook();
	}

	@Override
	public ArrayList<KeywordAutoCompletionVO> getAutoKeyword(String type, String keyoword) {
		
		ArrayList<KeywordAutoCompletionVO> keywordList = mapper.getAutoKeyword(type, keyoword);
		
		if(type.equals("title")) {
			for(KeywordAutoCompletionVO keyword : keywordList) {
				keyword.setHashTagList(mapper.getAutoKeywordHashtag(keyword.getBookNum()));
			}
		}
		
		
		return keywordList;
	}
	
	
	
}
