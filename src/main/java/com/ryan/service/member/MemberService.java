package com.ryan.service.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import com.ryan.domain.member.MemberAllDataVO;
import com.ryan.domain.member.MemberVO;

public interface MemberService {
	//회원가입
	public boolean memberSignUp(MemberVO member);
	
	//아이디 닉네임 체크
	public boolean signUpCheck(MemberVO member);
	
	//회원정보수정
	public boolean memberUpdate(MemberVO member , ArrayList<MultipartFile> files, HttpServletRequest request);
	
	//로그인 유효성 검사
	public boolean memberSignIn(MemberVO member);
	
	//로그인한 사람 정보 가져오기
	public MemberVO getLoginMemberInfo(MemberVO member);
	
	//정지중인 회원인지 체크
	public boolean memberBanCheck(MemberVO member);
	
	//비밀번호 찾기 할시 비밀번호 변경
	public boolean forgotPassword(MemberVO member);
	
	//회원탈퇴전 회원의 데이터를 리턴
	public MemberAllDataVO getMemberAllData(MemberVO member);
	
	//회원탈퇴전 비밀번호 확인
	public boolean memberPasswordCheck(MemberVO member);
	
	public boolean memberDelete(MemberVO member);
	
	public void memememe(MemberVO member);
	
}
