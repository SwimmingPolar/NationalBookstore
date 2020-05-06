package com.ryan.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.domain.ReviewVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.service.main.ReviewServiceImpl;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl service;
	
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		if(member == null) {
			response.sendRedirect("/member/login");
			return false;
		} else {
			return true;
		}
		
	}
	
	@RequestMapping("/ebookWrite")
	public void insertEbookReview(@ModelAttribute("review")ReviewVO review) {
		
		//등록자가 이미 리뷰한 책인지 검사
		//여부에 따라 검사 혹은 리뷰있음을 알림
		
	}
	
	@RequestMapping("/bookWrite")
	public void insertBookReview(@ModelAttribute("review")ReviewVO review) {
		
	}
	
	@RequestMapping("/delete")
	public String deleteReview(@ModelAttribute("ryanMember")MemberVO member,int bookNum) {
		String memberEmail=member.getMemberEmail();
		if(service.duplicationChk(memberEmail, bookNum)) {
			return service.delecteReview(memberEmail, bookNum)? "정상삭제시 갈 jsp":"실패문구";
		}else
			return "삭제할리뷰가존재하지않음";
	}
	
	@RequestMapping("/update")
	public void updateReview(@ModelAttribute("ryanMember")MemberVO member,@ModelAttribute("review")ReviewVO review) {
		//
	}
}
