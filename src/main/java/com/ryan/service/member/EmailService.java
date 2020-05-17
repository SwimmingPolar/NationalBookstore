package com.ryan.service.member;

import com.ryan.domain.member.EmailCheckVO;

public interface EmailService {
	
	//인증 코드 입력
	public boolean authenticationReady(EmailCheckVO email);
	
	//이메일 보내기
	public boolean authenticationCodeSend(EmailCheckVO email);
	
	//인증확인
	public boolean authenticationCheck(EmailCheckVO email);
	
	public boolean updateAuthComplete(EmailCheckVO email);
	
	//인증완료된 유저인지 확인
	
	public boolean authCompleteCheck(EmailCheckVO email);
	
}
