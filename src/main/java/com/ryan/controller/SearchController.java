package com.ryan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String searchBook(Model model,HttpServletRequest request,@RequestParam("writer") String writer,@RequestParam("bookname") String bookname) {
		/*
		 * Enumeration <String> test=request.getAttributeNames();
		 * 
		 * HashMap<String,Object> map=new HashMap<String,Object>(); for(int
		 * i=0;test.hasMoreElements();i++) { String x=""+i+""; map.put(x,
		 * test.nextElement()); }
		 */
		String [] temp = keyword.split("\\s+");
		model.addAttribute("BookList", service.searchBookM(temp));
		
		
		model.addAttribute("BookList", service.searchBookM(writer,bookname));
		
		System.out.println("크기는"+service.searchBookM(writer,bookname).size());
		
		return "결과값";
	}
	
	//검색후 페이지 이동 관련 전부있음
	@RequestMapping("/paging")
	public String paging(Model model,HttpServletRequest request) {
		
		
		
		return null;
	}
	
	
	@GetMapping("/searchType")
	public String searchType() {
		
		return "test";
	}
	
}
