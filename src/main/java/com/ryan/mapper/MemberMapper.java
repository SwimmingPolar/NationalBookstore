package com.ryan.mapper;

import com.ryan.domain.MemberVO;

public interface MemberMapper {
	//회원가입
	public int memberSignUp(MemberVO member);
	
	//아이디, 닉네임 중복체크
	public int signUpCheck(MemberVO member);
	
	//회원정보수정
	public int memberUpdate(MemberVO member);
	
	//로그인
	public int memberSignIn(MemberVO member);
	
	//쿠키용
	
	//로그인한 회원의 닉네임 획득
	public String getMemberNickName(MemberVO member);
	
	//자동 로그인 확인용
	public int autoLogin(MemberVO member);
	
}
