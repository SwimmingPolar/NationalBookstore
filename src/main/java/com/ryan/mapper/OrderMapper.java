package com.ryan.mapper;

import com.ryan.domain.OrderVO;

public interface OrderMapper {
	
	//주문번호생성
	public int insertOrder(OrderVO order);
	
}
