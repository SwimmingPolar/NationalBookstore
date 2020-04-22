package com.ryan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.CartVO;
import com.ryan.mapper.OrderObjectMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class OrderObjectServiceImpl implements OrderObjectService {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderObjectMapper mapper;
	
	
	@Override
	public boolean insertOrderObject(int orderNumber, ArrayList<CartVO> cartBuyList) {
		return mapper.insertOrderObject(orderNumber, cartBuyList) > 0 ? true : false;
	}
	
	
	
}
