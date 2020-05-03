package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryan.domain.payment.CartVO;
import com.ryan.domain.payment.OrderVO;
import com.ryan.service.payment.CartService;
import com.ryan.service.payment.OrderObjectService;
import com.ryan.service.payment.OrderService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/order/*")
//@SessionAttributes("cartBuyList") //혹시  orderPage 에서  목록이 안보이면 주석 해제 해주세요.
@Log4j
public class OrderController {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderService orderService;
	
	@Setter(onMethod_ = {@Autowired})
	private OrderObjectService objService;
	
	@Setter(onMethod_ = {@Autowired})
	private CartService cartService;
	
	//결제하는 페이지
	@RequestMapping("/orderPage")
	public String movingOrderPage(@ModelAttribute("cartBuyList") ArrayList<CartVO> cartBuyList) {
		//request 로 보내줌
		return "보여줄 경로";
	}
	
	//결제신청 - > 완료
	@RequestMapping("/order")
	public String bookOrder(OrderVO order, @ModelAttribute("cartBuyList") ArrayList<CartVO> cartBuyList , HttpServletRequest request) {
		//장바구니에서 결제하기 클릭한 목록들만 세션에 담아 처리합니다.
		
		//주문 상세 정보 입력, 주소등등 결제완료시 
		int orderNumber = orderService.insertOrder(order); // 주문번호 리턴
		
		if(objService.insertOrderObject(orderNumber, cartBuyList)) {
			cartService.removeBuyCartList(cartBuyList, request);
			return "결제성공페이지"; // 결제 실패 페이지 도 있으면 좋을거 같아요.
		} else {
			return "실패";
		}
	}
	
	//결제한 내역 주문리스트
	@RequestMapping("/list")
	public String orderList(HttpServletRequest request, Model model) {
		
		model.addAttribute("orderList", orderService.getOrderList(request));
		
		return "주문한 목록 보여줄 페이지";
	}
	
}
