package com.ryan.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.EBookVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DetailBookMapperTests {
	
	
	@Setter(onMethod_ = {@Autowired})
	private DetailBookMapper mapper;
	
	/*
	 * @Test public void searchEBook() {
	 * 
	 * log.info(mapper.searchEBook(1)); }
	 */
//	@Test
//	public void searchReview() {
//		log.info(mapper.searchReview(1));
//	}
//	
	
	@Test
	public void interestbooks() {
		
//		mapper.interestbooks("판타지").forEach(ebook -> log.info(ebook));
		
//		List<EBookVO> bookList = mapper.interestbooks("판타지");
		
		
	}
	
	
	
	
	
}
