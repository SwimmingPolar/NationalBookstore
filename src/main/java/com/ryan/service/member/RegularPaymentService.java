package com.ryan.service.member;

import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.KakaoPayApprovalVO;

public interface RegularPaymentService {
	
	//카카오페이 정기결제 준비
	public String regularPaymentReady(MemberVO member, int price);
	
	//카카오페이 정기결제 완료
	public KakaoPayApprovalVO paymentComplete(String pg_token , MemberVO member);
	
	//카카오페이 정기결제 취소
	
	
	//결제 정보 입력
	public boolean insertPaymentInfo(String memberEmail, String memberSid, String memberTid, String flag);
	
	//스케쥴
	public void autoRegularPaymentSystem();
	
	//정기결제 내역
	
	
	
}
