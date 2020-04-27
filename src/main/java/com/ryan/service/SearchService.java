package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.EBookVO;
import com.ryan.domain.PageVO;

public interface SearchService {
	//검색결과 책리스트
	public ArrayList<EBookVO> searchBookM(String writer,String bookname);
	
	//검색한 결과중 현물책 리스트
	public  ArrayList<EBookVO> bookList(ArrayList<EBookVO> tmpArr);
	
	//e북이나 현물북의 페이지 요청이 있을시 페이지 번호를 받고 해당 페이지 북리스트를 넘긴다
	public  ArrayList<EBookVO> pageList(ArrayList<EBookVO> tmpList,int pageNum);

}
