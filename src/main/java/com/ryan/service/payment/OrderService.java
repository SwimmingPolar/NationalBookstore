package com.ryan.service.payment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.ryan.domain.payment.KakaoPayApprovalVO;
import com.ryan.domain.payment.OrderVO;

public interface OrderService {
	
	//구매 완료
	public int insertOrder(OrderVO order);
	
	//구매리스트 가져오기
	public ArrayList<OrderVO> getOrderList(Authentication auth);
	
	//카카오페이
	public String kakaoPayTest();
	
	//카카오페이 결제승인
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token);
	
	
}
