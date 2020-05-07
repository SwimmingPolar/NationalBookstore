package com.admin.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.payment.OrderVO;

public interface DeliveryManagement {
	
	// 보고싶은 요청에 따른 주문 리스트 가져오기
	public ArrayList<OrderVO> getOrderList(@Param("status") String status);
	
	//운송장 번호 입력
	public int updateTrackingNumber(OrderVO order);
	
	//상태 변경
	public int updateStatus(@Param("orderNumber") int[] orderNumber, @Param("status") String status);
	
	
}
