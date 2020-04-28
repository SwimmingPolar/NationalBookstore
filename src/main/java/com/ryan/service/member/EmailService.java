package com.ryan.service.member;

import com.ryan.domain.member.EmailCheckVO;

public interface EmailService {
	
	//인증 코드 입력
	public boolean insertEmailCode(EmailCheckVO email);
	
	//이메일 보내기
	public boolean authenticationCodeSend(EmailCheckVO email);
	
	//인증확인
	public boolean authenticationCheck(EmailCheckVO email);
	
}
