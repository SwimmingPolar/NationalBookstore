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
	
	//로그인 유효성 체크
	public int memberSignIn(MemberVO member);
	
	//로그인한 사람 정보 가져오기
	public MemberVO getLoginMemberInfo(MemberVO member);
	
	//정지중인 회원인지 확인.
	public int memberBanCheck(MemberVO member);
	
	
	//회원탈퇴
	public int memberSignDelete(@Param("tableList") String[] tableList, @Param("memberEmail") String memberEmail);
	
	//비밀번호 찾기 할시 비밀번호 변경
	public int forgotPassword(MemberVO member);
	
}
