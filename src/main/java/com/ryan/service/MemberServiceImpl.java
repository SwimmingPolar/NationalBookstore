package com.ryan.service;

import java.util.regex.Matcher;
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
		
		//아이디 이메일형식
		Pattern id = Pattern.compile("^[\\d\\w]+@(=?.*?[\\w]+)[\\d\\w]*\\.[\\w]+(\\.[\\w]+){0,1}$");
		Matcher idMatcher = id.matcher(member.getMemberId());
		Pattern pw = Pattern.compile("^(?=.*?[^\\s])[\\w\\d]{4,}$");
		Matcher pwMatcher = pw.matcher(member.getMemberPw());
		Pattern nickName = Pattern.compile("^[a-z][\\d\\w]{3,11}");
		Matcher nickMatcher = nickName.matcher(member.getMemberNickName());
		
		if(!idMatcher.find())return false;
		if(!pwMatcher.find()) return false;
		if(!nickMatcher.find()) return false;
		
		try {
			return mapper.memberSignUp(member) == 1 ? true : false;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	
	@Override
	public boolean signUpCheck(MemberVO member) {
		return mapper.signUpCheck(member) == 1 ? true : false;
	}
	
	

}
