package com.ryan.service.payment;

import java.util.ArrayList;

import com.ryan.domain.payment.CartVO;

public interface OrderObjectService {
	
	public boolean insertOrderObject(int orderNumber, ArrayList<CartVO> cartBuyList);
	
}
