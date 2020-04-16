package com.ryan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.domain.HashtagVO;
import com.ryan.service.DetailBookService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/book/*")
@Log4j
public class DetailBookController {
	
	@Autowired
	private DetailBookService service;
	
	//상세보기 페이지 
	@RequestMapping("/search")
	public String searchEBook(int booknumber, Model model) {
		
		EBookVO vo = service.searchEBook(booknumber);
				
		model.addAttribute("bookdetail", vo);
		
		model.addAttribute("bookreview", service.searchReview(booknumber));		
		
		model.addAttribute("booklist", service.interestbooks(vo.getCategory()));
		
		BookLikeVO likevo = service.bookLike(booknumber);		
		model.addAttribute("booklike", likevo);
		
		model.addAttribute("bookgrade", service.bookGrade(booknumber));
		
		model.addAttribute("hashtag", service.hashtag(booknumber));
		
		//좋아요 한 사람들 랜덤 조회
		model.addAttribute("likepeople", service.likepeople(likevo.getMemberId()));
		
		return "view";				
	}
	
	@RequestMapping("/inserthashtag")
	public String insertHashtag(HashtagVO vo) {
		int num = service.insertHashtag(vo);
		if(num==1) {
			return "view";
		}else {
			log.info("입력실패");
			return "view";
		}
	}
	
	@Scheduled(cron = "0 0 00 * * ?") //매일 0시에 실행
	public void resetInsert() { 
		//태그 입력가능하게 설정
	}
}
