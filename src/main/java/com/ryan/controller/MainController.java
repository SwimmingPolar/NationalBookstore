package com.ryan.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.main.FilterSearchVO;
import com.ryan.domain.main.KeywordAutoCompletionVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.mapper.MainMapper;
import com.ryan.service.main.MainPageService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {
	
	@Setter(onMethod_ = {@Autowired})
	private MainPageService service;
	
	@GetMapping("/")
	public String mainPage(HttpServletRequest request, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			try {
				RyanMember ryanMember = (RyanMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if(ryanMember != null) {
					MemberVO member = ryanMember.getMember();
					model.addAttribute("interests", service.getinterests(member));
				} else {
					model.addAttribute("interests", service.getinterests(null));
				}
			}catch (Exception e) {
				model.addAttribute("interests", service.getinterests(null));
			}
			
		} else {
			model.addAttribute("interests", service.getinterests(null));
		}
		
		model.addAttribute("todayBook", service.getTodayBookList());
		model.addAttribute("bestReadBook", service.getBestReadBook());
		model.addAttribute("disCountBook", service.getDisCountBook());
		
		return "main";
	}
	
	
	@GetMapping("/best-seller")
	public @ResponseBody ArrayList<EBookVO> responseBestSeller(@RequestParam("time") String time, @RequestParam("category") String category){
		return service.getBestSeller(time, category);
	}
	
	@GetMapping("/search-preview")
	public @ResponseBody ArrayList<KeywordAutoCompletionVO> autoKeyword(@RequestParam("type") String type , @RequestParam("keyword") String keyword) {
		
		return service.getAutoKeyword(type, keyword);
		
	}
	
	@GetMapping("/myaccount")
	public String myAccountMain(Authentication auth) {
		
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		
		return "Settings/MyAccount/myAccount-main";
	}
	
	@GetMapping("/goSubscribe")
	public String goSubscribe() {
		return "Settings/MyAccount/goSubscribe";
	}
	
	@GetMapping("/updateMyInfo")
	public String updateMyInfo() {
		
		return "Settings/MyAccount/update";
	}
	
	@GetMapping("deleteMyInfo")
	public String deleteMyInfo() {
		return "Settings/MyAccount/delete";
	}
	
//	@GetMapping("myAccount-main")
	
//	@GetMapping("/filterSearch")
//	public String filterSearch(FilterSearchVO filterSearch, Model model) {
//		
//		model.addAttribute("키", service.getFilterSearch(filterSearch));
//		
//		return "주소";
//	}
	
	@GetMapping("/test")
	public String gsdag(@RequestParam("page") String page) {
		
		return page;
	}

}
