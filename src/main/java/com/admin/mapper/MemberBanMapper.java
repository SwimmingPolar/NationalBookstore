package com.admin.mapper;

import java.util.ArrayList;

import com.admin.domain.member.MemberBanVO;

public interface MemberBanMapper {
	
	//회원 정지 사유..입력?
	public int insertMemberBan(MemberBanVO memberBan);
	
	//정지중인 회원 명단 가져오기
	public ArrayList<MemberBanVO> getBanList();
	
	//정지 이력이 있는 회원들 가져오기
	public ArrayList<MemberBanVO> getBanHistory();
	
	/////////////////////////////////////////////////
	
	//여기부터 자동으로 정지해제
	
	//오늘 날짜에 정지가 풀리는 회원명단 가져오기
	public ArrayList<MemberBanVO> getTodayMemberLiberationList();
	
	//회원 정지 해제 시키기
	public void memberLiberation(ArrayList<MemberBanVO> memberBanList);
	
}
