package com.ryan.service.member;

import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.KakaoPayApprovalVO;

public interface RegularPaymentService {
		
	public String regularPaymentReady(MemberVO member);
	
	public KakaoPayApprovalVO paymentComplete(String pg_token , MemberVO member);
	
	//결제 정보 입력
	public boolean insertPaymentInfo(String memberEmail, String memberSid);
	
}
