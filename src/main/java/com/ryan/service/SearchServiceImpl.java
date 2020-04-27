package com.ryan.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
		
		ArrayList<EBookVO> vo=new ArrayList<EBookVO>();
		if(writer!=null) {
			if(writer.length()>0) {
				String [] w=writer.split("\\s+");
				//vo.addAll(mapper.typeWriter(w));
				vo.addAll(mapper.typeWriter(w));
				
				System.out.println(vo.get(3).getBookTitle()+"제목");
				System.out.println(vo.size()+"저자");
				
			}
		}else if(bookname!=null) {
			if(bookname.length()>0){
				String [] bn=bookname.split("\\s+");
				//vo.addAll(mapper.);
				vo.addAll(mapper.typeBookname(bn));
				//System.out.println(vo.get(3).getBookTitle());
				System.out.println(vo.size()+"북네임");
				System.out.println(vo.get(0).getBookTitle());

			}
		}else {
			
		}
		return vo;
	}
	@Override
	public ArrayList<PageVO> paging(PageVO pageInfo) {
		// TODO Auto-generated method stub
		return null;
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
}
