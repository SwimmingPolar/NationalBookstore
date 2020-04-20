package com.ryan.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.domain.HashtagVO;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DetailBookMapperTest {
	
	@Setter(onMethod_ = {@Autowired})
	private DetailBookMapper mapper;
	
//	@Test
//	public void bookLike() {
//		log.info(mapper.bookLike(1));
//	}
	/*
	@Test
	public void bookGrade() {
		log.info(mapper.bookGrade(1));
	}
	
	
	
	@Test
	public void  hashtag() {
		log.info(mapper.hashtag(1));
	}
	
	*/
	
	/*
	@Test
	public void likepeople() {
		log.info(mapper.likepeople("abc1234@naver.com"));
	}
	
	*/
//	@Test
//	public void insertHashtag() {
//		HashtagVO vo = new HashtagVO();
//		vo.setBookNum(1);
//		vo.setHashNum(1);
//		vo.setHashTag("흥미진진");
//		log.info(mapper.insertHashtag(vo));
//	}
/*	
	@Test
	public void insertGrade() {
		BookGradeVO vo = new BookGradeVO();
		
		vo.setBookNum(1);
		vo.setGradeNum(1);
		vo.setGradeScore(5);
		vo.setMemberId("abc1234@naver.com");
		
		log.info(mapper.insertGrade(vo));
	}
	
	*/
/*	
	@Test
	public void insertLike() {
		BookLikeVO vo = new BookLikeVO();
		
		vo.setLikeNum(1);
		vo.setBookNum(1);
		vo.setMemberId("abc1234@naver.com");
		
		log.info(mapper.insertLike(vo));
	}
	
	*/
	
	@Test
	public void deleteLike() {
		BookLikeVO vo = new BookLikeVO();
		vo.setBookNum(1);
		vo.setMemberId("abc1234@naver.com");
		
		log.info(mapper.deleteLike(vo));
	}
}
