package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.OrderVO;

public interface OrderService {
	
	public int insertOrder(OrderVO order);
	
	public ArrayList<OrderVO> getOrderList(HttpServletRequest request);
	
}
