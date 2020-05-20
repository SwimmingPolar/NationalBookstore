package com.ryan.mapper;

import com.ryan.domain.member.EmailCheckVO;

public interface EmailMapper {
	
	//이미 인증번호를 눌렀던 이메일인지 확인 // 데이터가있으면 이미누른 사람
	public int checkEmailAuthData(EmailCheckVO email);
	
	//존재할경우 코드 업데이트 // 위에서 데이터가있으면 업데이트 // 여기서 유효성도 0으로 돌려줌
	public int updateAuthenticationCode(EmailCheckVO email);
	
	//email SELECT Key return // 이건 insert
	public int insertEmailCode(EmailCheckVO email);
	
	//인증번호확인 // 인증번호 체크고
	public int authenticationCheck(EmailCheckVO email);
	//인증완료되면 인증유효성 업데이트 // 유효성업데이트
	public int updateAuthComplete(EmailCheckVO email);
	
	//인증완료된 유저인지 확인. // 마지막에 한번더 검사 // 3분뒤하는것도 이거 재활용
	public boolean authCompleteCheck(EmailCheckVO email);

	//1이 아니고 0이면 코드 제거 일단은
	public int emailCodeDelete(EmailCheckVO email);
	
}
