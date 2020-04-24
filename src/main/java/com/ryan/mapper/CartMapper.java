package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.CartVO;

public interface CartMapper {
	
	//담기
	public int insertCart(CartVO cart);
	//목록
	public ArrayList<CartVO> getCartList(String memberEmail);
	
	//수량 수정
	public int modifyCartCount(@Param("bookCount") int bookCount ,@Param("cartNum") int cartNum);
	
	//1개 삭제
	public int remove(int cartNum);
	
	//전체삭제
	public int removeAll(String memberEmail);
	
	//구하기 누른상품 구매페이지로
	public ArrayList<CartVO> cartBuyList(int[] cartNumArray);
	
	//구매한 내역 삭제 
	public void removeBuyCartList(ArrayList<CartVO> cartBuyList , @Param("memberEmail") String memberEmail);
	
}
