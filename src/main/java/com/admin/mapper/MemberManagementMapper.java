package com.admin.mapper;

import java.util.ArrayList;

import com.admin.domain.member.MemberManagementVO;
import com.admin.domain.member.MemberSignupCountVO;
import com.admin.domain.revenue.RegularPaymentRevenueVO;
import com.admin.domain.revenue.SearchDateVO;

public interface MemberManagementMapper {
	
	//회원 관리
	
	//회원 가입 날짜 가져오기
	public ArrayList<String> getMemberSignupDate();
	
	//회원 날짜에 대한 가입인원수 가져오기
	public ArrayList<MemberSignupCountVO> getMemberSignupCount(SearchDateVO searchDate);
	
	//구독자 가입수는 재탕..구독수익이 곧 구독자 가입했던 수 돈나감  = 가입 /// 유지보수 쉽게 새로 선언 sql 문은 동일함.
	public ArrayList<RegularPaymentRevenueVO> getSubscriptionCount(SearchDateVO searchDate);
	
	//현재 구독중인 회원 조회
	public ArrayList<MemberManagementVO> getSubscriptionMember();
	
}
