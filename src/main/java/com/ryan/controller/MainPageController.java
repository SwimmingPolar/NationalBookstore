package com.ryan.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.main.FilterSearchVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.mapper.MainMapper;
import com.ryan.service.main.MainPageService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainPageController {
	
	@Setter(onMethod_ = {@Autowired})
	private MainPageService service;
	
	@GetMapping("/")
	public String mainPage(HttpServletRequest request, Model model) {
		
		model.addAttribute("todayBook", service.getTodayBookList());
		model.addAttribute("bestReadBook", service.getBestReadBook());
		model.addAttribute("disCountBook", service.getDisCountBook());
		
		return "main";
	}
	
	
	@GetMapping("/ajaxBestSeller")
	public @ResponseBody ArrayList<EBookVO> responseBestSeller(@RequestParam("time") String time, @RequestParam("category") String category){
		return service.getBestSeller(time, category);
	}
	
	
//	@GetMapping("/search")
//	public String search(@RequestParam("type") String type , @RequestParam("keyword") String keyword, Model model) {
//		
//		String[] keywordArr = keyword.split(" ");
//		
//		HashMap<String, ArrayList<EBookVO>> result = new HashMap<String, ArrayList<EBookVO>>();
//		//model.addAttribute("ebook", sv.searchEbook(vo));
//		//model.addAttribute("paper", sv.searchPaperbook(vo));
//		model.addAttribute("result", result);
//		return "search";
//		
//	}
//	
//	@GetMapping("/test")
//	public String searchTest() {
//		
//		return "search";
//	}
	
	
	@GetMapping("/filterSearch")
	public String filterSearch(FilterSearchVO filterSearch, Model model) {
		
		model.addAttribute("키", service.getFilterSearch(filterSearch));
		
		return "주소";
	}
	
	@RequestMapping(value="/paper")
	public String Paper() {
		return "paper";
	}
	
	@RequestMapping(value="/books")
	public String Books() {
		return "books";
	}
	
	@RequestMapping(value="/books/all")
	public String BooksAll() {
		return "all";
	}
	
	@RequestMapping(value="/bestseller")
	public String BestSeller() {
		return "all";
	}
	
}
