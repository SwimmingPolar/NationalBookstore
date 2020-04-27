package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ryan.domain.KakaoPayApprovalVO;
import com.ryan.domain.OrderVO;

public interface OrderService {
	
	//구매 완료
	public int insertOrder(OrderVO order);
	
	//구매리스트 가져오기
	public ArrayList<OrderVO> getOrderList(HttpServletRequest request);
	
	//카카오페이
	public String kakaoPayTest();
	
	//카카오페이 결제승인
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token);
	
	
}
