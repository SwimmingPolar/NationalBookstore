package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.domain.HashtagVO;
import com.ryan.domain.MyLibVO;
import com.ryan.domain.ReviewVO;
import com.ryan.service.DetailBookService;
import com.ryan.service.MyBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/book/*")
@Log4j
public class DetailBookController {
	
	@Autowired
	private DetailBookService service;
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookService mservice;
	
	//상세보기 페이지 
	@RequestMapping("/search")
	public String searchEBook(@RequestParam("booknumber") int booknumber, Model model, HttpServletRequest request, HttpServletResponse response) {
	
		EBookVO vo = service.searchEBook(booknumber);
		
		//조회수
		service.updateBookLookUp(vo, request, response);
				
		model.addAttribute("bookdetail", vo);
		
		model.addAttribute("bookreview", service.searchReview(booknumber));		//
		
		model.addAttribute("booklist", service.interestbooks(vo.getCategory()));//
		
		model.addAttribute("booklike", service.bookLike(booknumber));
		
		model.addAttribute("bookgrade", service.bookGrade(booknumber));
		
		model.addAttribute("hashtag", service.hashtag(booknumber));//
		
		//좋아요 한 사람들 랜덤 조회
		model.addAttribute("likepeople", service.likepeople(vo.getBookNum()));
		
		return "view";				
	}
	
	@RequestMapping("/inserthashtag")
	public String insertHashtag(HashtagVO vo, HttpServletRequest request, HttpServletResponse response) {		
		service.hashtagCookie(vo, request, response);

		return "view";
	}
	
	//평점 입력
	@RequestMapping("/insertgrade")
	public @ResponseBody double insertGrade(BookGradeVO vo) {
		return service.insertGrade(vo);
	}
	
	//좋아요 입력
	@RequestMapping("/insertlike")
	public @ResponseBody int insertLike(BookLikeVO vo, HttpServletRequest request, HttpServletResponse response) {
		return service.insertLike(vo, request, response);
	}
	
	@RequestMapping("/insertList")
	public String insertList(Model model, MyLibVO vo) {
		boolean flag = mservice.insertList(vo);
		model.addAttribute("booklist", mservice.readingBook(vo));
		if(flag) {			
			model.addAttribute("message", "등록되었습니다.");
		}else {
			model.addAttribute("message", "이미 등록된 작품입니다.");
		}
		return "view";
	}
	
}
