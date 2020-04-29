package com.ryan.mapper;

import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
	
	public int insertPaymentInfo(@Param("memberEmail") String memberEmail,@Param("memberSid") String memberSid);
	
}
