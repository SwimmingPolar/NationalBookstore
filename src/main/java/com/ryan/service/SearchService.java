package com.ryan.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.EBookVO;
import com.ryan.domain.PageVO;

public interface SearchService {
	//검색결과 책리스트
	public ArrayList<EBookVO> searchBookM(String writer,String bookname);
	
	//검색한 결과중 현물책 리스트
	public  ArrayList<EBookVO> bookList(ArrayList<EBookVO> tmpArr);
	
<<<<<<< HEAD
	//e북이나 현물북의 페이지 요청이 있을시 페이지 번호를 받고 해당 페이지 북리스트를 넘긴다
	public  ArrayList<EBookVO> pageList(ArrayList<EBookVO> tmpList,int pageNum);

=======
	/////////////////////////////////////이 아래로 제가 수정좀 했습니다.
	//ebook 검색
	public List<EBookVO> searchEbook(String type, String[] keyword) throws ClassNotFoundException, SQLException;
	//종이책 검색
	public List<EBookVO> searchPaperbook(String type, String[] keyword) throws ClassNotFoundException, SQLException;

	
>>>>>>> branch 'master' of https://github.com/SwimmingPolar/NationalBookstore.git
}
