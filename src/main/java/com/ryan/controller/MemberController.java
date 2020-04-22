package com.ryan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
	//인증코드 5분 지나면
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
	public String memberLogin(@RequestParam(required = false, name = "autoLogin") String autoLogin , MemberVO member ,HttpServletRequest request, HttpServletResponse response) {
		if(memberService.memberSignIn(member)) {
			if(autoLogin != null) {
				member.setMemberNickName(memberService.getMemberNickName(member));
				memberService.removeCookie(response);
				memberService.addCookie(member, response);
			}
			HttpSession session = request.getSession();
			session.setAttribute("ryanMember", member);
			return "main";
		} else {
			return "login";
		}

	}
	
	@GetMapping("/login")
	public String memberLoginasd() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String memew(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		memberService.removeCookie(response);
		
		return "main";
	}
	
	@GetMapping("/test")
	public String memgw() {
		return "test";
	}
	
//	//체크박스 예시 삭제예정
//	@GetMapping("ex")
//	public String ex0101(@RequestParam(required = false, name = "checkbox") String[] das) {
//		return "ex11";
//	}
	
}
