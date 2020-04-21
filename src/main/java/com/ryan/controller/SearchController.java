package com.ryan.controller;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.mapper.SearchMapper;

@Controller
@RequestMapping("/search/*")
public class SearchController {
	@Autowired
	private SearchMapper mapper;
	
	@RequestMapping("/searchBook")
	public void searchBook(Model model,HttpServletRequest request) {
		Enumeration <String> test=request.getAttributeNames();

		HashMap<String,Object> map=new HashMap<String,Object>();
		for(int i=0;test.hasMoreElements();i++) {
			String x=""+i+"";
			map.put(x, test.nextElement());
		}

		mapper.searchBook(map);
		
	}
	
}
