package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.domain.CartVO;
import com.ryan.domain.OrderVO;
import com.ryan.service.OrderObjectService;
import com.ryan.service.OrderService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order/*")
@Log4j
public class OrderController {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderService orderService;
	
	@Setter(onMethod_ = {@Autowired})
	private OrderObjectService objService;
	
	//결제하는 페이지
	@RequestMapping("/orderPage")
	public String movingOrderPage(@ModelAttribute("cartBuyList") ArrayList<CartVO> cartBuyList) {
		//request 로 보내줌
		return "보여줄 경로";
	}
	
	//결제신청 - > 완료
	@RequestMapping("/order")
	public String bookOrder(OrderVO order, @RequestParam("cartBuyList") ArrayList<CartVO> cartBuyList) {
		//jsp request 로 한번더 보내줌
		
		//주문 상세 정보 입력, 주소등등 결제완료시
		int orderNumber = orderService.insertOrder(order); // 주문번호 리턴
		
		if(objService.insertOrderObject(orderNumber, cartBuyList)) {
			return "결제성공페이지";
		} else {
			return "실패";
		}
	}
	
	//결제한 내역 주문리스트
	@RequestMapping("/list")
	public String orderList(HttpServletRequest request, Model model) {
		
		model.addAttribute("orderList", orderService.getOrderList(request));
		
		return "주문리스트페이지";
	}
	
}
