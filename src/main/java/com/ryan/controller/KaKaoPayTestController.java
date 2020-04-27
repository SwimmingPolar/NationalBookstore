package com.ryan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.service.OrderService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class KaKaoPayTestController {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderService service;
	
	@GetMapping("/kakao")
	public void gege() {
		
	}
	
	@PostMapping("/kakaPay")
	public String kakaoPayTest() {
		log.info("kakaoPay post test...");
		return "redirect:" + service.kakaoPayTest();
	}
	
	@GetMapping("/kakaoPaySuccess")
	public void kaka(@RequestParam("pg_token") String pg_token, Model model) {
		log.info("pg_token: " + pg_token);
		model.addAttribute("info", service.kakaoPayInfo(pg_token));
	}
	
}
