package com.ryan.service;

import java.util.regex.Pattern;

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
		
		//아이디
		Pattern id = Pattern.compile("/^[a-z0-9]");
		
		int result = mapper.memberSignUp(member);
				

		return result == 1 ? true : false;
	}
	
	
	@Override
	public boolean signUpCheck(MemberVO member) {
		return mapper.signUpCheck(member) == 1 ? true : false;
	}
	
	

}
