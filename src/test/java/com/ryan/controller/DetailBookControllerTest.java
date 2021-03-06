package com.ryan.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.book.BookLikeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.service.book.DetailBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DetailBookControllerTest {
	
	@Setter(onMethod_ = {@Autowired})
	private DetailBookService service;
	
	@Test
	public void searchEBook() {

		
		log.info(service.hashtag(197));

	
	}

	/*
	@Test
	public void insertLike() {
		BookLikeVO vo = new BookLikeVO();
		vo.setBookNum(1);
		vo.setMemberEmail("abc1234@naver.com");
		
	
	}
	*/

}
