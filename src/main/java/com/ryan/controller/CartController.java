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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.CartVO;
import com.ryan.service.payment.CartService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cart/*")
@SessionAttributes({"ryanMember","cartBuyList"})
@Log4j
public class CartController {
	
	@Setter(onMethod_ = {@Autowired})
	private CartService cartService;
	
	/*
	 else "실패" 가있는건 확인을 위하여 만듬
	 
	 보여줄 페이지명 < 만드신 페이지 이름으로 변경해주세요
	 */
	
	@PostMapping("/insert")
	public @ResponseBody Boolean insertCart(CartVO[] cart, @ModelAttribute("ryanMember") MemberVO member) {
		
		if(cartService.insertCart(cart,member)) { // 장바구니 입력 성공시 true 리턴해줍니다 필요하시면 쓰면됩니다.
			return true; 
		} 
		
		return false;
	}
	
	//장바구니 페이지 이동
	@GetMapping("/list")
	public String getCartList(Model model,@ModelAttribute("ryanMember") MemberVO member) {
		
		model.addAttribute("cartList", cartService.getCartList(member));
		
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
		 //삭제를 원하는 상품의 cartNum 을 보내주세요 , Ajax 비동기 처리방식 필요하면 말해주세요.
		
		
		if(cartService.remove(cartNum)) return "redirect:/cart/list";
		else return "실패";
	}
	
	@RequestMapping("/removeAll") //버튼 하나 만들고 경로 입력해주면 됩니다.
	public String removeAll(@ModelAttribute("ryanMember") MemberVO member) {
		
		
		if(cartService.removeAll(member)) return "redirect:/cart/list";
		else return "실패";
	}
	
	@RequestMapping("/buy")
	public String buy(@RequestParam("cartNum") int[] cartNumArray , Model model) {
		//cartNumArray 로 장바구니 정보 list 에 저장 
		model.addAttribute("cartBuyList", cartService.cartBuyList(cartNumArray));
		return "redirect:/order/orderPage";
	}
	
}
