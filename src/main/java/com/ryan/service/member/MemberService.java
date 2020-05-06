package com.ryan.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	//정지중인 회원인지 체크
	public boolean memberBanCheck(MemberVO member);
	
	//비밀번호 암호화
	
	
	//쿠키용
	
	//자동로그인 체크시 쿠키생성
	public void addCookie(MemberVO member, HttpServletResponse response);
	
	//자동로그인 누를시 전에있던 쿠키 삭제
	public void removeCookie(HttpServletResponse response);
	
	//서버접속시 쿠키확인후 쿠키데이터로 DB데이터 확인 로그인처리
	public boolean autoLogin(MemberVO member);
	
	//로그인한 회원의 닉네임 획득
	public String getMemberNickName(MemberVO member);
	
	
	
}
