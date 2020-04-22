package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.MemberVO;
import com.ryan.domain.OrderVO;
import com.ryan.mapper.OrderMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class OrderServiceImpl implements OrderService {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper mapper;
	
	
	@Override
	public int insertOrder(OrderVO order) {
		return mapper.insertOrder(order);
	}


	@Override
	public ArrayList<OrderVO> getOrderList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		return mapper.getOrderList(member.getMemberEmail());
	}
	
	
	
}
