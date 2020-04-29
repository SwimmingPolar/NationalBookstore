package com.ryan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.mapper.MyBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBookServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;

	/*
	@Test
	public void readingBook(){
		MyLibVO vo = new MyLibVO();
		vo.setBookNum(196);
		vo.setMemberEmail("abc1234@naver.com");
		log.info(mapper.readingBook(vo));
	}
	
	@Test
	public void insertList() {
		boolean flag = false;
		MyLibVO vo = new MyLibVO();
		vo.setBookNum(196);
		vo.setMemberEmail("abc1234@naver.com");
		
	}
	*/
	
	@Test
	public void readBookList() {
		MyReadBookVO vo = new MyReadBookVO();
		vo.setBookNum(197);
		vo.setMemberEmail("abc1234@naver.com");
		log.info(mapper.readBookList(vo));
	}
	/*
	@Test
	public void insertReadBook() {
		MyReadBookVO vo = new MyReadBookVO();
		vo.setBookNum(197);
		vo.setMemberEmail("abc1234@naver.com");
		log.info(mapper.insertReadBook(vo));
	}
	*/
	/*
	@Test
	public void deleteReadBook() {
		MyReadBookVO vo = new MyReadBookVO();
		vo.setBookNum(197);
		vo.setMemberEmail("abc1234@naver.com");
		log.info(mapper.deleteReadBook(vo));
	}
	
*/
}
