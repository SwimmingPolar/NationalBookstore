package com.ryan.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.domain.book.EBookVO;
import com.ryan.service.main.SearchService;

@Controller
public class BookListController {
	@Autowired
	private SearchService sv;
	
	@RequestMapping(value="/booklist")
	public String getBooks(@RequestParam(value="genre", required=false) String genre, @RequestParam(value="sub_genre", required=false) String sub_genre, @RequestParam(value="page", required=false) String page, @RequestParam(value="sort", required=false) String sort, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("전체책목록(param1:"+genre+";param2:"+sub_genre+";param3:"+page+";param4:"+sort+")");
		
		List<EBookVO> result = new ArrayList<EBookVO>();
		result = sv.getFilterSearch(genre, sub_genre, page, sort);
		int length = sv.getFilterSearchCount(genre, sub_genre, page).size();
		
		model.addAttribute("result", result);
		model.addAttribute("length", length);
		return "booklist";
	}
}
