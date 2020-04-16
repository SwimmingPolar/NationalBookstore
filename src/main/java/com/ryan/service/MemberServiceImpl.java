package com.ryan.service;

import org.springframework.stereotype.Service;

import com.ryan.domain.MemberVO;
import com.ryan.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	@Override
	public boolean memberSignUp(MemberVO member) {
		
		int result = mapper.memberSignUp(member);
				
//		if (result == 1) return true;
//		else return false;
		return result == 1 ? true : false;
	}
	
	
	@Override
	public boolean signUpCheck(MemberVO member) {
		return mapper.signUpCheck(member) == 1 ? true : false;
	}
	
	

}
