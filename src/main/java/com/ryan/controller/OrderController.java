package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@Log4j
public class OrderController {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderService orderService;
	
	@Setter(onMethod_ = {@Autowired})
	private OrderObjectService objService;
	
	@Setter(onMethod_ = {@Autowired})
	private CartService cartService;
	
	//결제하는 페이지
	@GetMapping("/orderPage")
	public String movingOrderPage() {
		return "보여줄 경로";
	}
	
	//결제신청 - > 완료
	@RequestMapping("/order")
	public String bookOrder(OrderVO order,HttpSession session , HttpServletRequest request) {
		//장바구니에서 결제하기 클릭한 목록들만 세션에 담아 처리합니다.
		
		ArrayList<CartVO> cartBuyList = (ArrayList<CartVO>) session.getAttribute("cartBuyList");
		
		//주문 상세 정보 입력, 주소등등 결제완료시 
		order.setOrderStatus("배송 준비중");
		int orderNumber = orderService.insertOrder(order); // 주문번호 리턴
		
		if(objService.insertOrderObject(orderNumber, cartBuyList)) {
			cartService.removeBuyCartList(cartBuyList, request);
			session.removeAttribute("cartBuyList"); // 세션 삭제
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
