package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.member.PaymentVO;

public interface PaymentMapper {
	
	public int insertPaymentInfo(@Param("memberEmail") String memberEmail,@Param("memberSid") String memberSid, @Param("memberTid") String memberTid , @Param("flag") String flag);
	
	public ArrayList<PaymentVO> getTodayRegularPaymentList();
	
}
