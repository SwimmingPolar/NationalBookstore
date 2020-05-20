package com.ryan.service.payment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.CartVO;

public interface CartService {
	
	public boolean insertCart(CartVO[] cart);
	
	public ArrayList<CartVO> getCartList(MemberVO member);
	
	public boolean modifyCartCount(int bookCount, int cartNum);
	
	//1개삭제
	public boolean remove(int cartNum);
	//전체삭제
	public boolean removeAll(MemberVO member);
	
	//구매하기 체크한 상품들보내주기
	public ArrayList<CartVO> cartBuyList(int[] cartNumArray);
	
	//구매 완료하고 구매한상품 삭제
	public void removeBuyCartList(ArrayList<CartVO> cartBuyList, HttpServletRequest request);
	
}
