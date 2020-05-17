package com.ryan.mapper;

import com.ryan.domain.member.EmailCheckVO;

public interface EmailMapper {
	
	//이미 인증번호를 눌렀던 이메일인지 확인
	public int checkEmailAuthData(EmailCheckVO email);
	
	//존재할경우 코드 업데이트
	public int updateAuthenticationCode(EmailCheckVO email);
	
	//email SELECT Key return
	public int insertEmailCode(EmailCheckVO email);
	
	//인증확인
	public int authenticationCheck(EmailCheckVO email);
	
}
