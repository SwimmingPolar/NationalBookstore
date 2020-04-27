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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.domain.HashtagVO;
import com.ryan.domain.MyLibVO;
import com.ryan.domain.MyReadBookVO;
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
				
		model.addAttribute("bookdetail", vo); //책 정보- 상세정보
		
		model.addAttribute("bookreview", service.searchReview(booknumber));		//책 번호 - 리뷰
		
		model.addAttribute("booklist", service.interestbooks(vo.getBookCategory()));// 카테고리 추천 도서

		model.addAttribute("likecheck", service.checkLike(booknumber, request)); //좋아요 클릭 했는지 확인
		
		model.addAttribute("booklike", service.bookLike(booknumber)); //좋아요 수
		
		model.addAttribute("bookgrade", service.bookGrade(booknumber)); //평점
		
		model.addAttribute("hashtag", service.hashtag(booknumber));//해쉬태그 
		
		//좋아요 한 사람들 랜덤 조회
		model.addAttribute("likepeople", service.likepeople(vo.getBookNum()));
		
		return "view";				
	}
	
	@RequestMapping("/inserthashtag")
	public String insertHashtag(HashtagVO vo, HttpServletRequest request, HttpServletResponse response) {		
		service.hashtagCookie(vo, request, response);

		return "view";
	}
/*	
	//평점 입력
	@RequestMapping("/insertgrade")
	public @ResponseBody Double insertGrade(BookGradeVO vo) {
		log.info("grade 실행");
		double num = service.insertGrade(vo);
		log.info(num);
		return num;
	}
	*/
	
	//좋아요 입력
	@RequestMapping("/insertlike")
	public @ResponseBody int insertLike(@RequestParam("booknumber") int booknumber, HttpServletRequest request, HttpServletResponse response) {
		return service.insertLike(booknumber, request, response);
	}
	
	//찜 책장에 추가
	@RequestMapping("/insertList")
	public @ResponseBody Boolean insertList(Model model, MyLibVO vo) {
		return mservice.insertList(vo);
	}
	
	//읽은책 추가
	@RequestMapping("/insertreadbook")
	public @ResponseBody int insertReadBook(MyReadBookVO vo) {
		return mservice.insertReadBook(vo);
	}
	
}
