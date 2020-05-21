package com.ryan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.BookAlarmVO;
import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
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
	public String myBookList(@RequestParam(name="clickId", required = false) String clickId,Model model, Authentication auth) {
		Boolean flag = false;
		Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
		if(auth2 != null) {
			try {
				RyanMember ryanMember = (RyanMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if(ryanMember != null) {
					MemberVO member = (MemberVO) ryanMember.getMember();
					if(clickId != null && !clickId.equals("")) {
						if(member.getMemberEmail().equals(clickId)) {	//clickId 가 있는데 본인이면 false 리턴
							model.addAttribute("checkId",flag);
							clickId = member.getMemberEmail();
						} else {			//clickId 가 있고 본인이 아니면 true 리턴
							flag = true;
							model.addAttribute("checkId",flag);
							model.addAttribute("followCheck", fservice.followCheck(member.getMemberEmail(), clickId));
							model.addAttribute("followId",service.readClickId(clickId));
						}
					}else {	//clickId 가 없으면 본인 false 리턴
						model.addAttribute("checkId",flag);
						clickId = member.getMemberEmail();
					}
				}
			}catch (Exception e) {
				if(clickId != null && !clickId.equals("")) {
					flag = true;
					model.addAttribute("checkId",flag);
					model.addAttribute("followId",service.readClickId(clickId));
					//		model.addAttribute("followCheck",service.followCheck());
				} else {
					return "redirect:/member/signin"; // 로그인도 안한거고 클릭한 아이디도 없을경우
				}
			}
		}	
		ArrayList<EBookVO> list = service.libBook(clickId,auth2);
		model.addAttribute("libbooklist", list);
		model.addAttribute("libcount",service.countLibBook(clickId,auth2));		//찜 책장 수량
		model.addAttribute("readbooklist", service.readBook(clickId,auth2));	//읽은책 리스트
		model.addAttribute("readbookcount", service.countReadBook(clickId,auth2)); 		//읽은책 수량
		model.addAttribute("likeBookcount", service.countLikeBook(clickId,auth2));
		model.addAttribute("myFollower",fservice.countFollow(clickId,auth2)); //내가 팔로우한사람
		model.addAttribute("followerList", fservice.getMyFollowing(clickId, auth2));
		model.addAttribute("myreviewlist", rservice.myReviewList(clickId));
		model.addAttribute("reviewcnt", rservice.countMyPost(clickId));
		
		/*
		 * model.addAttribute("myreviewlist",
		 * rservice.myReviewList(auth2));//내reviewlist
		 */		return "myLibrary";
	}
	
	
	@RequestMapping(value = "/deleteLibList", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ArrayList<EBookVO> deleteList(HttpServletRequest request, @RequestParam("memberEmail") String memberEmail) {
		String[] ajaxResult = request.getParameterValues("booknum");
		int[] booknum = new int[ajaxResult.length];
		for(int i=0; i<ajaxResult.length;i++) {
			booknum[i] = Integer.parseInt(ajaxResult[i]);
		}
		//return service.deleteLibBook(booknum, session)
		return service.deleteLibBook(booknum, request, memberEmail);
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
	public @ResponseBody Boolean requestAlarm(@RequestParam("booknumber") int booknumber, @RequestParam("memberEmail") String memberEmail) {
		return aservice.requestAlarm(booknumber, memberEmail);
	}
	
	//출판 되어 알람시켜줘야 할 책 
	public ArrayList<BookAlarmVO> showAlarm(Authentication auth){
		return aservice.showAlarm(auth);
	}

	
	//메인에서 출판일자별로 신작예정도서 출력
	
	//평점 등록
	@RequestMapping("/insertGrade")
	public @ResponseBody ArrayList<BookGradeVO> insertGrade(BookGradeVO vo, @RequestParam("memberEmail") String memberEmail) {
		return service.insertGrade(vo, memberEmail);
	}
	

		
}
