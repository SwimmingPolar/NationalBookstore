package com.ryan.mapper;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.member.MemberAllDataVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.OrderVO;

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
	//다른사람의 서재 닉네임 가져오기
	public MemberVO readClickId(String clickId);
	
	//여기부터 회원탈퇴
	//이용현황
	public int myLibCount(MemberVO member);
	public int myPostCount(MemberVO member);
	public int myfollowCount(MemberVO member);
	public int myRealBookBuyCount(int[] orderNumberArr);
	//주문번호
	public int[] getMemberOrderNumber(MemberVO member);
	
	//
	public String getMemberPassword(MemberVO member);
	
	//삭제
	public int deleteMemberData(MemberVO member);
	
	//회원의 read_book no 를 가져옴
	public int[] getMemberReadBookNO(MemberVO member);
	
	//북마크랑 삭제
	public int deleteMemberBookMark(int[] readBookNoArray);
	
	//read book 삭제
	public int deleteMemberReadBook(MemberVO member);
	
	//주문내역삭제
	public int deleteMemberOrderObject(int[] orderNumberArray);
	
	//주문번호삭제
	public int deleteMemberOrderNumber(MemberVO member);
	
	//장바구니삭제
	public int deleteMemberCart(MemberVO member);
	
	//마지막 회원정보 제거
	public int deleteMember(MemberVO member);
	
}
