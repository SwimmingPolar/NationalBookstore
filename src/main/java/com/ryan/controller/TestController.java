package com.ryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class TestController {
	
	@RequestMapping("/test1")
	public String getget() {
		
		return "payment";
	}
	@RequestMapping("/test2")
	public String oror() {
		
		return "orderDetailInfo";
	}
	@RequestMapping("/test3")
	public String sdsadsa() {
		
		return "myLibrary";
	}
	@RequestMapping("/test4")
	public String dsagsag() {
		
		return "myInfoUpdate";
	}
	
	
}
