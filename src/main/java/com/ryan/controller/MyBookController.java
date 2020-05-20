package com.ryan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.BookAlarmVO;
import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.service.book.MyBookAlarmService;
import com.ryan.service.book.MyBookService;
import com.ryan.service.main.ReviewService;
import com.ryan.service.member.FollowService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booklist/*")
@Log4j
public class MyBookController {

	@Setter(onMethod_ = {@Autowired})
	private MyBookService service;
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookAlarmService aservice;
	
	@Setter(onMethod_ = {@Autowired})
	private FollowService fservice;
	
	@Setter(onMethod_ = {@Autowired})
	private ReviewService rservice;
	
	@RequestMapping("/myLibList")	//찜 책장
	public String myBookList(@RequestParam(name="clickId", required = false) String clickId,Model model, HttpSession session) {
		Boolean flag = false;
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		if(clickId != null && clickId != "") {
			if(member != null && member.getMemberEmail().equals(clickId)) {
				model.addAttribute("checkId",flag);
			} else {
				flag = true;
				model.addAttribute("checkId",flag);
				model.addAttribute("followId",service.readClickId(clickId));
		//		model.addAttribute("followCheck",service.followCheck());
			}
		}else {
			if(member != null) {
				model.addAttribute("checkId",flag);
			} else {
				return "redirect:/member/signin";
			}
		}
		ArrayList<EBookVO> list = service.libBook(clickId,session);
		model.addAttribute("libbooklist", list);
		model.addAttribute("libcount",service.countLibBook(clickId,session));		//찜 책장 수량
		model.addAttribute("readbooklist", service.readBook(clickId,session));	//읽은책 리스트
		model.addAttribute("readbookcount", service.countReadBook(clickId,session)); 		//읽은책 수량
		model.addAttribute("likeBookcount", service.countLikeBook(clickId,session));
		model.addAttribute("myFollower",fservice.countFollow(clickId,session)); //나를 팔로우 한 사람
		model.addAttribute("myreviewlist", rservice.myReviewList(session));//내 reviewlist
		return "myLibrary";
	}
	
	
	@RequestMapping("/deleteLibList")
	@ResponseBody
	public ArrayList<EBookVO> deleteList(HttpServletRequest request) {
		String[] ajaxResult = request.getParameterValues("booknum");
		int[] booknum = new int[ajaxResult.length];
		for(int i=0; i<ajaxResult.length;i++) {
			booknum[i] = Integer.parseInt(ajaxResult[i]);
		}
		//return service.deleteLibBook(booknum, session)
		return service.deleteLibBook(booknum, request);
	}
	
//	@RequestMapping("/readbooklist") 	//읽은 책 조회
//	public String myReadBook(Model model, HttpSession session) {
//		model.addAttribute("readbooklist", service.readBook(session));	//읽은책 리스트
//		model.addAttribute("readbookcount", service.countReadBook(session)); 		//읽은책 수량
//		return "myLibrary";
//	}
	
	//읽은 책 목록에서 삭제하기
	@RequestMapping("/deletereadbook")
	public @ResponseBody List<EBookVO> deleteReadBook(MyReadBookVO vo) {
		return service.deleteReadBook(vo);
	}
	
	//알람 받을 책 등록
	@RequestMapping("/alarm")
	public @ResponseBody Boolean requestAlarm(BookAlarmVO vo, HttpSession session) {
		return aservice.requestAlarm(vo, session);
	}
	
	//출판 되어 알람시켜줘야 할 책 
	public ArrayList<BookAlarmVO> showAlarm(HttpSession session){
		return aservice.showAlarm(session);
	}

	
	//메인에서 출판일자별로 신작예정도서 출력
	
	//평점 등록
	@RequestMapping("/insertGrade")
	public @ResponseBody ArrayList<BookGradeVO> insertGrade(BookGradeVO vo, HttpSession session) {
		return service.insertGrade(vo, session);
	}
	

		
}
