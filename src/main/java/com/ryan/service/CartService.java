package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.CartVO;

public interface CartService {
	
	public boolean insertCart(CartVO cart);
	
	public ArrayList<CartVO> getCartList(HttpServletRequest request);
	
	public boolean modifyCartCount(int bookCount, int cartNum);
	
	//1개삭제
	public boolean remove(int cartNum);
	//전체삭제
	public boolean removeAll(HttpServletRequest request);
}
