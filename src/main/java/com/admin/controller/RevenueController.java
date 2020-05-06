package com.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.domain.revenue.SearchDateVO;
import com.admin.service.revenue.RevenueService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/revenue/*")
@Log4j
public class RevenueController {
	
	//수익 컨트롤러
	
	@Setter(onMethod_ = {@Autowired})
	private RevenueService service;
	
	@InitBinder // 모든 컨트롤러 실행전에 실행됨
	public void initBinder(WebDataBinder binder) {
		log.info("initBinder 시작!");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	//구독페이지에서 날짜로 요청
	@PostMapping("/subscription") // 메서드명 변경해주기..
	public String moveRegularPaymentRevenuPage(SearchDateVO searchDate, Model model) {
		
		model.addAttribute("choiceList", service.getRegularPaymentRevenueDate());
		model.addAttribute("regularList", service.getRegularPaymentRevenue(searchDate));
		
		return "test123"; //페이지로 바꿔주세요
	}
	
	//구독 수익 보는 페이지로 이동
	@GetMapping("/subscription")
	public String moveRegularPaymentRevenuePage(Model model) {
		
		model.addAttribute("choiceList", service.getRegularPaymentRevenueDate());
		
		return "test123";
	}
	
	////책수익관련
	
	//책 수익
	@GetMapping("/book")
	public String moveBookPaymentRevenuePage(Model model) {
		
		model.addAttribute("choiceList", service.getBookPaymentRevenueDate());
		
		return "페이지";
	}
	
	//책 수익 페이지에서 날짜로 요청
	public String getBookPaymentRevenue(SearchDateVO searchDate, Model model) {
		
		model.addAttribute("choiceList", service.getBookPaymentRevenueDate());
		model.addAttribute("bookList", service.getBookPaymentRevenue(searchDate));
		
		return "페이지";
	}
	
}
