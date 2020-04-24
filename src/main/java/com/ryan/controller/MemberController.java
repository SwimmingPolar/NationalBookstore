package com.ryan.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.EmailCheckVO;
import com.ryan.domain.MemberVO;
import com.ryan.service.BookCategoryService;
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
	
	@Setter(onMethod_ = {@Autowired})
	private BookCategoryService categoryService;
	
	@PostMapping("/signUp")
	public String memberSignUp(MemberVO member) {
		log.info(member.getMemberEmail());
		if (memberService.memberSignUp(member)) return "회원가입 성공 페이지";
		else return "회원가입 실패 페이지";		
	}
	
	@RequestMapping("/signUpCheck")
	public @ResponseBody Map<String, Boolean> signUpCheck(MemberVO member) {
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		
		if(memberService.signUpCheck(member)) {
			resultMap.put("result", true);
			return resultMap;
		} else {
			resultMap.put("result", false);
			return resultMap;
		}
	}
	
	@RequestMapping("/emailAuthentication")
	public @ResponseBody Map<String, Boolean> emailAuthenticationCodeSend(EmailCheckVO email) {
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		
		if(emailService.insertEmailCode(email)) { // DB에 인증정보 입력성공시 PK 키 리턴.. 
			if(emailService.authenticationCodeSend(email)) { //메일보내기 성공하면
				resultMap.put("result", true);
				return resultMap;
			}
		}
		
		return resultMap;
	}
		
//	//인증코드 5분 지나면
//	@RequestMapping("미정")
//	public @ResponseBody Map<String, Boolean> sadsafoka() {
//	}
	
	//인증완료
	@PostMapping("/authenticationCheck")
	public @ResponseBody Map<String, Boolean> authenticationCheck(EmailCheckVO email) {
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		
		if(emailService.authenticationCheck(email)) { // 인증성공 true
			resultMap.put("result", true);
		} else {
			resultMap.put("result", false);
		}
		return resultMap;
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
	
	@GetMapping("/logout")
	public String memew(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		memberService.removeCookie(response);
		
		return "main";
	}
	@GetMapping("/email-signin")
	public String getEmailLogin() {
		return "email-signin";
	}
	@GetMapping("/signin")
	public String getSignIn() {
		return "signin";
	}
	@GetMapping("/signup")
	public String getMemberSignUp() {
		return "signup";
	}
	
<<<<<<< HEAD
	@GetMapping("/test")
	public String memgw() {
		return "home";
	}
=======
	
>>>>>>> c3b34c2405ef0c4ce4a89596f2ed0e7221b3b6be
	
//	//체크박스 예시 삭제예정
//	@GetMapping("ex")
//	public String ex0101(@RequestParam(required = false, name = "checkbox") String[] das) {
//		return "ex11";
//	}
	
	
	// 관심 카테고리 등록 페이지 이동
	@GetMapping("/몰라")
	public String skwnddpwjdgka(Model model) {
		
		model.addAttribute("categoryList", categoryService.getBookCategory());
		return "카테고리 등록 페이지 써주에요";
	}
	
	@PostMapping("/memberInterestsInsert")
	public String memberInterestsInsert(@RequestParam(required = false, name = "categoryCheck") int[] categoryArray) {
		
		
		
		return "카테고리 등록 완료 페이지";
	}
	
	
	
}
