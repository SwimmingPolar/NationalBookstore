package com.ryan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.MemberVO;
import com.ryan.service.MemberService;

import lombok.Setter;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@PostMapping("/signUp")
	public String memberSignUp(MemberVO member) {
		
		if (service.memberSignUp(member))
			return "회원가입 성공 페이지";
		else return "회원가입 실패 페이지";		
	}
	
	@RequestMapping("signUpCheck")
	public @ResponseBody boolean signUpCheck(MemberVO member) {
		
		if(service.signUpCheck(member))
			return true;
		else return false;
		
	}
	
	
}
