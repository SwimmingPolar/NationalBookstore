package com.ryan.mapper;

import com.ryan.domain.member.EmailCheckVO;

public interface EmailMapper {
	
	//email SELECT Key return
	public int insertEmailCode(EmailCheckVO email);
	
	//인증확인
	public int authenticationCheck(EmailCheckVO email);
	
}
