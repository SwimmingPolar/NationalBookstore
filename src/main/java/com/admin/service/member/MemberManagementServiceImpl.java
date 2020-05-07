package com.admin.service.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.member.MemberManagementVO;
import com.admin.domain.member.MemberSignupCountVO;
import com.admin.domain.revenue.RegularPaymentRevenueVO;
import com.admin.domain.revenue.SearchDateVO;
import com.admin.mapper.MemberManagementMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberManagementServiceImpl implements MemberManagementService {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberManagementMapper mapper;

	@Override
	public ArrayList<String> getMemberSignupDate() {
		return mapper.getMemberSignupDate();
	}

	@Override
	public ArrayList<MemberSignupCountVO> getMemberSignupCount(SearchDateVO searchDate) {
		return mapper.getMemberSignupCount(searchDate);
	}
	
	@Override
	public ArrayList<RegularPaymentRevenueVO> getSubscriptionCount(SearchDateVO searchDate) {
		return mapper.getSubscriptionCount(searchDate);
	}

	@Override
	public ArrayList<MemberManagementVO> getSubscriptionMember() {
		return mapper.getSubscriptionMember();
	}

	
	
	
	
}
