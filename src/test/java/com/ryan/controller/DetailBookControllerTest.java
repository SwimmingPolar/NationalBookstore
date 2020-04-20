package com.ryan.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.service.DetailBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DetailBookControllerTest {
	
	@Setter(onMethod_ = {@Autowired})
	private DetailBookService service;
/*	
	@Test
	public void searchEBook() {
		log.info(service.searchEBook(1));
		log.info(service.searchReview(1));
		
		
		EBookVO vo = service.searchEBook(1);		

		
		log.info(service.interestbooks(vo.getCategory()));
		
		log.info(service.bookLike(1));
		BookLikeVO likevo = service.bookLike(1);		

		
		log.info(service.bookGrade(1));
		
		log.info(service.hashtag(1));
		
		//좋아요 한 사람들 랜덤 조회
		log.info(service.likepeople(likevo.getMemberId()));
	
	}
*/	
	@Test
	public void insertLike() {
		BookLikeVO vo = new BookLikeVO();
		vo.setBookNum(1);
		vo.setMemberEmail("abc1234@naver.com");
		
		log.info(service.insertLike(vo, 1));
	}
	

}
