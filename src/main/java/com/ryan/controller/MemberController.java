package com.ryan.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.service.revenue.RevenueService;
import com.ryan.domain.member.EmailCheckVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.KakaoPayApprovalVO;
import com.ryan.service.book.BookCategoryService;
import com.ryan.service.member.EmailService;
import com.ryan.service.member.InterestsService;
import com.ryan.service.member.MemberService;
import com.ryan.service.member.RegularPaymentService;

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
	
	@Setter(onMethod_ = {@Autowired})
	private InterestsService interestsService;
	
	@Setter(onMethod_ = {@Autowired})
	private RegularPaymentService paymentService;
	
	//통계
	@Setter(onMethod_ = {@Autowired})
	private RevenueService revenueService;
	
	@PostMapping("/signUp")
	public String memberSignUp(MemberVO member) {
		if (memberService.memberSignUp(member)) return "main";
		else return "회원가입 실패 페이지";		
	}
	
	@PostMapping("/signUpCheck")
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
	
	@PostMapping("/emailAuthentication")
	public @ResponseBody Map<String, Boolean> emailAuthenticationCodeSend(EmailCheckVO email) {
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>(); 
		
		if(emailService.authenticationReady(email)) { // DB에 인증정보 입력성공시 PK키 리턴.. 
			if(emailService.authenticationCodeSend(email)) { //메일보내기 성공하면
				resultMap.put("result", true);
				return resultMap;
			}
		}		
		
		return resultMap;
	}
	//pk키 추가해주기 or 5분뒤 삭제
	
	//인증완료
	@PostMapping("/authenticationCheck")
	public @ResponseBody Map<String, Boolean> authenticationCheck(EmailCheckVO email) {
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		
		if(emailService.authenticationCheck(email)) { // 인증성공 true
			if(emailService.updateAuthComplete(email)) {
				resultMap.put("result", true);
			}
		} else {
			resultMap.put("result", false);
		}
		return resultMap;
	}
	
	@PostMapping("/authenticationCompleteCheck")
	public @ResponseBody Map<String, Boolean> authenticationCompleteCheck(EmailCheckVO email) {
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		if(emailService.authCompleteCheck(email)) {
			resultMap.put("result", true);
		} else {
			resultMap.put("result", false);
		}
		
		return resultMap;
	}
	
	@PostMapping("/update")
	public String memberInfoUpdate(MemberVO member) {
		
		if (memberService.memberUpdate(member)) {
			log.info("controller member: " + member.getMemberPw());
		} else {
			log.info("member..!= null!");
		}
		return "업데이트 완료후 보여줄 페이지 경로";
	}
	
	@PostMapping("/signin")
	public String memberLogin(@RequestParam(required = false, name = "rememberMe") String remeberMe , MemberVO member ,HttpServletRequest request, HttpServletResponse response , Model model) {
		//정지중인 유저인지 체크하는 서비스 호출에서 검사할것 아직안함.
		
		if(memberService.memberSignIn(member)) {
			if(remeberMe != null) {
				member.setMemberNickName(memberService.getMemberNickName(member));
				memberService.removeCookie(response);
				memberService.addCookie(member, response);
			}
			HttpSession session = request.getSession();
			session.setAttribute("ryanMember", memberService.getLoginMemberInfo(member));
			log.info(request.getRemoteAddr());
			return "redirect:/"; 
		} else {
			return "redirect:/email-signin";
		}

	}
	
	@GetMapping("/logout")
	public String memberLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		memberService.removeCookie(response);
		return "redirect:/member/test";
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
	
	
	
	
	
	// 관심 카테고리 등록 페이지 이동
	@GetMapping("/몰라")
	public String skwnddpwjdgka(Model model) {
		
		model.addAttribute("categoryList", categoryService.getBookCategory());
		return "카테고리 등록 페이지 써주에요";
	}
	
	//관심 등록
	@PostMapping("/memberInterestsInsert")
	public String memberInterestsInsert(@RequestParam(required = false, name = "categoryCheck") int[] categoryArray, HttpServletRequest request) {
		
		if(interestsService.insertInterests(categoryArray, request)) {
			return "성공";
		} else {
			return "실패";
		}
		
	}
	
	
	//레뒤
	@PostMapping("/paymentReady")
	public String memberPaymentReady(@ModelAttribute("ryanMember") MemberVO member) {
		
		
		return "redirect:" + paymentService.regularPaymentReady(member);
	}
	
	//성공~
	@GetMapping("/paymentSuccess")
	public String memberPaymentSuccess(@RequestParam("pg_token") String pg_token, @ModelAttribute("ryanMember") MemberVO member, Model model) {
		
		KakaoPayApprovalVO kakaoPayApprovalVO = paymentService.paymentComplete(pg_token, member);
		
		if(paymentService.insertPaymentInfo(member.getMemberEmail(), kakaoPayApprovalVO.getSid())) {
			if(revenueService.insertRevenue()) {
				model.addAttribute("info", kakaoPayApprovalVO);
				
				return "kakaoPaySuccess"; // 결제 완료 페이지 써주세요~!
			}
			
		}
		
		return "결제 실패";
	}
	
	//환불~
	@GetMapping("/regularPaymentStop")
	public String temp() {
		return null;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	
//	@PutMapping
//	@DeleteMapping
//	@PatchMapping
	
	
	
}
