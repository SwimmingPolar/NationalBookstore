package com.ryan.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.member.MemberVO;
import com.ryan.mapper.MemberInterestsMapper;

import lombok.Setter;

@Service
public class InterestsServiceImpl implements InterestsService {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberInterestsMapper mapper;
	
	@Override
	public boolean insertInterests(int[] categoryArray, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		return mapper.insertInterests(member.getMemberEmail(), categoryArray) > 0 ? true : false;
	}
	
	
	
}
