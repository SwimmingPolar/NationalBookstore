package com.ryan.service.main;

import java.sql.SQLException;
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
	//ebook 리스트 가져오기
	@Override
	public List<EBookVO> searchEbook(String type, String[] keyword) throws ClassNotFoundException, SQLException {
		return mapper.searchEbook(type, keyword);
		//return sqlSession.getMapper(SearchMapper.class).searchEbook(type, keyword);
	}
	//종이책 리스트 가져오기
	@Override
	public List<EBookVO> searchPaperbook(String type, String[] keyword) throws ClassNotFoundException, SQLException {
		return mapper.searchPaperbook(type, keyword);
		//return sqlSession.getMapper(SearchMapper.class).searchPaperbook(type, keyword);
	}
	//ebook 페이징
	@Override
	public List<EBookVO> searchEbookPage(String type, String[] keyword, int pageNum) throws ClassNotFoundException, SQLException {
		return mapper.searchEbookPage(type, keyword, pageNum);
	}


	@Override
	public List<EBookVO> searchPaperbookPage(String type, String[] keyword,int pageNum) throws ClassNotFoundException, SQLException {
		return mapper.searchPaperbookPage(type, keyword, pageNum);
	}

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
}
