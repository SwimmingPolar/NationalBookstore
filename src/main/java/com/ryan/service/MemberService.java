package com.ryan.service;

import com.ryan.domain.MemberVO;

public interface MemberService {
	//회원가입
	public boolean memberSignUp(MemberVO member);
	
	//아이디 닉네임 체크
	public boolean signUpCheck(MemberVO member);
	
}
