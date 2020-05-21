package com.ryan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.ReviewVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.service.main.ReviewServiceImpl;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl service;
	
	/*
	 * @RequestMapping("/reviewWriteForm") public String
	 * reviewForm(HttpServletRequest request,Model model){ return ""; }
	 */
	
	//리뷰를 작성하고 입력 요청하면 처리
	@RequestMapping("/write")
	public String insertEbookReview(@ModelAttribute("review") ReviewVO review,Authentication auth,Model model) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		String memberEmail=member.getMemberEmail();
		review.setMemberEmail(memberEmail);
		
		
		
		boolean x=service.insertReview(review);
		/*
		 * if(memberEmail.equals((String)review.getMemberEmail())) {
		 * System.out.println("여기"); boolean x=service.insertReview(review);
		 * model.addAttribute("message", "입력 성공"); }else { model.addAttribute("message",
		 * "본인이 작성한 리뷰가 아닙니다");
		 * 
		 * }
		 */
		
		return "redirect:/booklist/myLibList";
	}
	
	@RequestMapping("/delete")
	public String deleteReview(Authentication auth,@ModelAttribute("review")  ReviewVO review,Model model) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		String memberEmail=member.getMemberEmail();
		
		if(memberEmail.equals((String)review.getMemberEmail())) {
			return service.delecteReview(review)? "정상삭제시 갈 jsp":"실패시";
		}else {
			model.addAttribute("message", "본인이 작성한 리뷰가 아닙니다");
			return "";
		}
	}
	
	@RequestMapping("/update")
	public String updateReview(@ModelAttribute("review") ReviewVO review,Authentication auth,Model model) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
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
	
	//review 목록요청시  model에 myreviewlist로 reviewVO어레이리스트를 보낸다
	/*@RequestMapping("/myReviewList")
	public String reviewList(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		String memberEmail=member.getMemberEmail();
		service.myReviewList(memberEmail);
		model.addAttribute("myreviewlist", service.myReviewList(memberEmail));
		return "myLibrary";
	}*/
}
