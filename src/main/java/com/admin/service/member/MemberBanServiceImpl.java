package com.admin.service.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.admin.domain.member.MemberBanVO;
import com.admin.mapper.MemberBanMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberBanServiceImpl implements MemberBanService {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberBanMapper mapper;
	
	@Override
	public boolean insertMemberBan(MemberBanVO memberBan) {
		return mapper.insertMemberBan(memberBan) == 1 ? true : false;
	}

	@Override
	public ArrayList<MemberBanVO> getBanList() {
		return mapper.getBanList();
	}

	@Override
	public ArrayList<MemberBanVO> getBanHistory() {
		return mapper.getBanHistory();
	}
	
	@Scheduled(cron="0 0 01 * * *") 
	@Override
	public void memberLiberation() {
		
		mapper.memberLiberation(mapper.getTodayMemberLiberationList());
		
	}
	
	
	
}
