package com.ryan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.domain.book.ReviewVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.service.main.ReviewServiceImpl;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl service;
	
	@RequestMapping("/write")
	public String insertEbookReview(@ModelAttribute @Valid ReviewVO review,BindingResult result,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals((String)review.getMemberEmail())) {
			return service.insertReview(review)? "정상입력시 갈 jsp":"실패시";
		}else
			return "본인 reivew가 아님";
	}
	
	@RequestMapping("/delete")
	public String deleteReview(HttpServletRequest request,@ModelAttribute @Valid ReviewVO review,BindingResult result) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals((String)review.getMemberEmail())) {
			return service.delecteReview(review)? "정상삭제시 갈 jsp":"실패시";
		}else
			return "본인 reivew가 아님";
		
	}
	
	@RequestMapping("/update")
	public String updateReview(@ModelAttribute @Valid ReviewVO review,BindingResult result,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals(review.getMemberEmail())) {
			return service.updateReview(review)? "정상수정시 갈 jsp":"실패시";
		}else
			return "본인 reivew가 아님";
	}
	
	@RequestMapping("/myReviewList")
	public String reviewList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		service.myReviewList((String) member.getMemberEmail());
		return service.myReviewList((String) member.getMemberEmail()) !=null ?"":"";
	}
}
