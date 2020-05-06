package com.ryan.mapper;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.member.MemberVO;

public interface MemberMapper {
	//회원가입
	public int memberSignUp(MemberVO member);
	
	//아이디, 닉네임 중복체크
	public int signUpCheck(MemberVO member);
	
	//회원정보수정
	public int memberUpdate(MemberVO member);
	
	//로그인
	public int memberSignIn(MemberVO member);
	
	//정지중인 회원인지 확인.
	public int memberBanCheck(MemberVO member);
	
	//쿠키용
	
	//로그인한 회원의 닉네임 획득
	public String getMemberNickName(MemberVO member);
	
	//자동 로그인 확인용
	public int autoLogin(MemberVO member);
	
	//회원탈퇴
	public int memberSignDelete(@Param("tableList") String[] tableList, @Param("memberEmail") String memberEmail);
	
}
