package com.ryan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
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
	
	@RequestMapping("/reviewForm")
	public String reviewForm(){
		
		return "";
	}
	
	@RequestMapping("/write")
	public String insertEbookReview(@ModelAttribute("review") ReviewVO review,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals((String)review.getMemberEmail())) {
			return service.insertReview(review)? "정상입력시 갈 jsp":"실패시";
		}else {
			model.addAttribute("message", "본인이 작성한 리뷰가 아닙니다");
			return "";
		}
	}
	
	@RequestMapping("/delete")
	public String deleteReview(HttpServletRequest request,@ModelAttribute("review")  ReviewVO review,Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals((String)review.getMemberEmail())) {
			return service.delecteReview(review)? "정상삭제시 갈 jsp":"실패시";
		}else {
			model.addAttribute("message", "본인이 작성한 리뷰가 아닙니다");
			return "";
		}
	}
	
	@RequestMapping("/update")
	public String updateReview(@ModelAttribute("review") ReviewVO review,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals(review.getMemberEmail())) {
			if(service.updateReview(review))
				model.addAttribute("message", "");
			else
				model.addAttribute("message", "본인이 작성한 리뷰가 아닙니다");
			return "";
		}else {
			model.addAttribute("message", "본인이 작성한 리뷰가 아닙니다");
			return "";
		}
	}
	
	@RequestMapping("/myReviewList")
	public String reviewList(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		String memberEmail=member.getMemberEmail();
		service.myReviewList(memberEmail);
		model.addAttribute("myreviewlist", service.myReviewList(memberEmail));
		return "";
	}
}
