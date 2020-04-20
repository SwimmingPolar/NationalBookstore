package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.CartVO;

public interface CartMapper {
	
	//담기
	public int insertCart(CartVO cart);
	//목록
	public ArrayList<CartVO> getCartList(String memberEmail);
	
	//수량 수정
	public int modifyCartCount(int bookCount , int cartNum);
	
	//1개 삭제
	public int remove(int cartNum);
	
	//전체삭제
	public int removeAll(String memberEmail);
	
}
