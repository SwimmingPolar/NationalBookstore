package com.ryan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.service.SearchServiceImpl;

@Controller
@RequestMapping("/search/*")
public class SearchController {
	
	@Autowired
	private SearchServiceImpl service;
	
	//검색
	@RequestMapping("/searchBook")
	public String searchBook(Model model,HttpServletRequest request,@RequestParam("keyword") String keyword) {
		/*
		 * Enumeration <String> test=request.getAttributeNames();
		 * 
		 * HashMap<String,Object> map=new HashMap<String,Object>(); for(int
		 * i=0;test.hasMoreElements();i++) { String x=""+i+""; map.put(x,
		 * test.nextElement()); }
		 */
		String [] temp = keyword.split("\\s+");
		model.addAttribute("BookList", service.searchBookM(temp));
		
		return "결과창";
	}
	
	//검색후 페이지 이동 관련 전부있음
	public String paging(Model model,HttpServletRequest request) {
		
		
		
		return null;
	}
}
