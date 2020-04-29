package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.payment.CartVO;

public interface OrderObjectMapper {
	
	//상세결제 내엽 입력
	public int insertOrderObject(@Param("orderNumber") int orderNumber, ArrayList<CartVO> cartBuyList);
	
}
