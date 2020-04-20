package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.CartVO;
import com.ryan.domain.MemberVO;
import com.ryan.mapper.CartMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CartServiceImpl implements CartService {
	
	@Setter(onMethod_ = {@Autowired})
	private CartMapper mapper;

	@Override
	public boolean insertCart(CartVO cart) {
		return mapper.insertCart(cart) == 1 ? true : false;
	}

	@Override
	public ArrayList<CartVO> getCartList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		return mapper.getCartList(member.getMemberEmail());
	}

	@Override
	public boolean modifyCartCount(int bookCount, int cartNum) {
		return mapper.modifyCartCount(bookCount, cartNum) == 1 ? true : false;
	}

	@Override
	public boolean remove(int cartNum) {
		return mapper.remove(cartNum) == 1 ? true : false;
	}

	@Override
	public boolean removeAll(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		return mapper.removeAll(member.getMemberEmail()) == 1 ? true : false;
	}

	@Override
	public ArrayList<CartVO> cartBuyList(int[] cartNumArray) {
		return mapper.cartBuyList(cartNumArray);
	}

	
	
	
	
}
