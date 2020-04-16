package com.ryan.mapper;

import com.ryan.domain.MemberVO;

public interface MemberMapper {
	//회원가입
	public int memberSignUp(MemberVO member);
	
	//아이디, 닉네임 중복체크
	public int signUpCheck(MemberVO member);
	
}
