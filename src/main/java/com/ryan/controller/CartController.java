package com.ryan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryan.domain.payment.CartVO;
import com.ryan.service.payment.CartService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cart/*")
@Log4j
public class CartController {
	
	@Setter(onMethod_ = {@Autowired})
	private CartService cartService;
	
	/*
	 else "실패" 가있는건 확인을 위하여 만듬
	 */
	
	@PostMapping("/insert")
	public @ResponseBody Boolean insertCart(CartVO cart) {
		
		if(cartService.insertCart(cart)) {
			return true;
		} 
		
		return false;
	}
	
	//장바구니 페이지 이동
	@GetMapping("/list")
	public String getCartList(Model model, HttpServletRequest request) {
		
		model.addAttribute("cartList", cartService.getCartList(request));
		
		return "보여줄 페이지명 써주세요";
	}
	
	//수량 수정 필요시 ajax
	@RequestMapping("/countModify")
	public String modifyCount(@RequestParam("bookCount") int bookCount ,@RequestParam("cartNum") int cartNum ) {
		
		//개발시 확인을위해서
		if(cartService.modifyCartCount(bookCount, cartNum)) {
			return "redirect:/cart/list";
		} else {
			return "실패";
		}
		
	}
	
	//장바구니 1개 삭제
	@RequestMapping("/remove")
	public String remove(@RequestParam("cartNum") int cartNum) {
		
		if(cartService.remove(cartNum)) return "redirect:/cart/list";
		else return "실패";
	}
	
	@RequestMapping("/removeAll")
	public String removeAll(HttpServletRequest request) {
		
		if(cartService.removeAll(request)) return "redirect:/cart/list";
		else return "실패";
	}
	
	@RequestMapping("/buy")
	public String buy(@RequestParam int[] cartNumArray , RedirectAttributes rttr) {
		//cartNumArray 로 장바구니 정보 list 에 저장 
		rttr.addFlashAttribute("cartBuyList", cartService.cartBuyList(cartNumArray));
		return "redirect:/order/orderPage";
	}
	
}
