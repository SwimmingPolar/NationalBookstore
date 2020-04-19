package com.ryan.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.EmailCheckVO;
import com.ryan.domain.MemberVO;
import com.ryan.service.EmailService;
import com.ryan.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
public class MemberController {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService memberService;
	
	@Setter(onMethod_ = {@Autowired})
	private EmailService emailService;
	
	@PostMapping("/signUp")
	public String memberSignUp(MemberVO member) {
		
		if (memberService.memberSignUp(member)) return "회원가입 성공 페이지";
		else return "회원가입 실패 페이지";		
	}
	
	@RequestMapping("/signUpCheck")
	public ResponseEntity<String> signUpCheck(MemberVO member) {
		
		if(memberService.signUpCheck(member)) {
			String msg = "{\"result\": \"true\"}";
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json;charset=UTF-8");
			
			return new ResponseEntity<String>(msg,header,HttpStatus.OK);
		} else {
			String msg = "{\"result\": \"false\"}";
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json;charset=UTF-8");
			
			return new ResponseEntity<String>(msg,header,HttpStatus.OK);
		}
	}
	
	@RequestMapping("/emailAuthentication")
	public @ResponseBody Boolean emailAuthenticationCodeSend(EmailCheckVO email) {
		
		email = emailService.insertEmailCode(email);
		if(email.getEmailNum() > 0) { // DB에 인증정보 입력성공시 PK 키 리턴.. 
			if(emailService.authenticationCodeSend(email)) { //메일보내기 성공하면
				return true;
			}
		}
		
		return false;
	}
		
	//인증코드 5분
	@RequestMapping("미정")
	public @ResponseBody Boolean sadsafoka() {
		return false;
	}
	
	//인증완료
	@PostMapping("/authenticationCheck")
	public @ResponseBody Boolean authenticationCheck(EmailCheckVO email) {
		
		if(emailService.authenticationCheck(email)) { // 인증성공 true
			return true;
		}
		
		return false;
	}
	
	@PostMapping("/update")
	public String memberInfoUpdate(MemberVO member) {
		
		//AJax 처리.
		if (memberService.memberUpdate(member)) {
			log.info("controller member: " + member.getMemberPw());
		} else {
			log.info("member..!= null!");
		}
		return "업데이트 완료후 보여줄 페이지 경로";
	}
	
	@PostMapping("/login")
	public String memberLogin(@RequestParam("autoLogin") String autoLogin , MemberVO member , HttpServletResponse response) {
		
		if(memberService.memberSignIn(member)) {
			if(autoLogin.equals("check")) {
				memberService.addCookie(member, response);
				return "메인";
			}
			return "메인";
		} else {
			return "login";
		}
		
		
		
	}
	
	  
}
