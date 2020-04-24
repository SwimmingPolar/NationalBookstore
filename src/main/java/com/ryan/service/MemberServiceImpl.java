package com.ryan.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ryan.domain.MemberVO;
import com.ryan.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	@Override
	public boolean memberSignUp(MemberVO member) {
		
		//아이디 이메일형식
		Pattern id = Pattern.compile("^[\\d\\w]+@(=?.*?[\\w]+)[\\d\\w]*\\.[\\w]+(\\.[\\w]+){0,1}$");
		Matcher idMatcher = id.matcher(member.getMemberEmail());
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


	@Override
	public boolean memberUpdate(MemberVO member) {
		
		Pattern pw = Pattern.compile("^(?=.*?[^\\s])[\\w\\d]{4,}$");
		Matcher pwMatcher = pw.matcher(member.getMemberPw());
		if(!pwMatcher.find()) return false;
		
		return mapper.memberUpdate(member) == 0 ? true : false;
	}

	
	@Override
	public void addCookie(MemberVO member, HttpServletResponse response) {
		
		
		Cookie idCookie = new Cookie("ryanMemberId", member.getMemberEmail());
		log.info("쿠키에 저장될 회원아이디값: " + member.getMemberEmail());
		idCookie.setMaxAge(60*60*24*7);
		idCookie.setPath("/");
		
		Cookie nickNameCookie = new Cookie("ryanMemberNickName", member.getMemberNickName());
		nickNameCookie.setMaxAge(60*60*24*7);
		nickNameCookie.setPath("/");
		response.addCookie(idCookie);
		response.addCookie(nickNameCookie);
		log.info("쿠키생성완료");
		log.info(idCookie);
	}
	
	@Override
	public void removeCookie(HttpServletResponse response) {
		Cookie idCookie = new Cookie("ryanMemberId", null);
		idCookie.setMaxAge(0);
		idCookie.setPath("/");
		
		Cookie nickNameCookie = new Cookie("ryanMemberNickName", null);
		nickNameCookie.setMaxAge(0);
		nickNameCookie.setPath("/");
		
		response.addCookie(idCookie);
		response.addCookie(nickNameCookie);
	}
	

	@Override
	public boolean autoLogin(MemberVO member) {
		return mapper.autoLogin(member) == 1 ? true : false;
	}


	@Override
	public boolean memberSignIn(MemberVO member) {
		return mapper.memberSignIn(member) == 1 ? true : false;
	}


	@Override
	public String getMemberNickName(MemberVO member) {
		return mapper.getMemberNickName(member);
	}


	
	

}
