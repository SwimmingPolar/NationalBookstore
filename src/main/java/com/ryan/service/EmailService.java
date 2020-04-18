package com.ryan.service;

import com.ryan.domain.EmailCheckVO;

public interface EmailService {
	
	//인증 코드 입력
	public EmailCheckVO insertEmailCode(EmailCheckVO email);
	
	//이메일 보내기
	public boolean authenticationCodeSend(EmailCheckVO email);
	
	//인증확인
	public boolean authenticationCheck(EmailCheckVO email);
	
}
