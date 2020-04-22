package com.ryan.service;

import java.util.ArrayList;

import com.ryan.domain.CartVO;

public interface OrderObjectService {
	
	public boolean insertOrderObject(int orderNumber, ArrayList<CartVO> cartBuyList);
	
}
