package com.ryan.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.domain.CartVO;
import com.ryan.domain.OrderVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order/*")
@Log4j
public class OrderController {
	
	
	@RequestMapping("/list")
	public String movingBuyPage(@ModelAttribute("cartBuyList") ArrayList<CartVO> cartBuyList) {
		return "보여줄 경로";
	}
	
	@RequestMapping("/order")
	public String bookOrder(OrderVO order, @RequestParam("cartBuyList") ArrayList<CartVO> cartBuyList) {
		return "결제완료후 보여줄 페이지..";
	}
	
}
