package com.ryan.service.member;

import com.ryan.domain.member.MemberVO;

public interface MemberService {
	//회원가입
	public boolean memberSignUp(MemberVO member);
	
	//아이디 닉네임 체크
	public boolean signUpCheck(MemberVO member);
	
	//회원정보수정
	public boolean memberUpdate(MemberVO member);
	
	//로그인 유효성 검사
	public boolean memberSignIn(MemberVO member);
	
	//로그인한 사람 정보 가져오기
	public MemberVO getLoginMemberInfo(MemberVO member);
	
	//정지중인 회원인지 체크
	public boolean memberBanCheck(MemberVO member);
	
	//비밀번호 찾기 할시 비밀번호 변경
	public boolean forgotPassword(MemberVO member);
	
	
	
}
