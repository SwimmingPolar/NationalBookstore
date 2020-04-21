package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.OrderVO;

public interface OrderMapper {
	
	//주문번호생성 + 주문상세내역 입력
	public int insertOrder(OrderVO order);
	
	//결제한리스트
	
	public ArrayList<OrderVO> getOrderList(String memberEmail);
	
}
