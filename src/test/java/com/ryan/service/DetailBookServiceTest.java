package com.ryan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.mapper.DetailBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DetailBookServiceTest {

	@Setter(onMethod_ = {@Autowired})
	private DetailBookService service;
	
	@Setter(onMethod_ = {@Autowired})
	private DetailBookMapper mapper;
	
//	@Test
//	public void bookLike() {
//		log.info(service.bookLike(1));
//	}
	
//	@Test
//	public void bookGrade() {
//		log.info(service.bookGrade(1));
//	}
//	
//	
//	
//	@Test
//	public void  hashtag() {
//		log.info(service.hashtag(1));
//	}
//	
//	
	

//	@Test
//	public void likepeople() {
//		log.info(service.likepeople("abc1234@naver.com"));
//	}
//	

//	@Test
//	public void insertHashtag() {
//		HashtagVO vo = new HashtagVO();
//		vo.setBookNum(1);
//		vo.setHashNum(2);
//		vo.setHashTag("흥미진진");
//		log.info(service.insertHashtag(vo));
//	}
	
//	@Test
//	public void insertGrade() {
//		BookGradeVO vo = new BookGradeVO();
//		
//		vo.setBookNum(1);
//		vo.setGradeNum(1);
//		vo.setGradeScore(5);
//		vo.setMemberId("abc1234@naver.com");
//		
	//	log.info(service.insertGrade(vo));
//	}
	
	
	
//	@Test
//	public void interestbooks() {
//		service.interestbooks("판타지").forEach(ebook -> log.info(ebook));
//	}
/*	
	@Test
	public void searchEBook() {
		log.info(service.searchEBook(1));
	}
	*/
	

	@Test
	public void insertLike() {
		boolean flag = false;
		BookLikeVO vo = new BookLikeVO();
		vo.setBookNum(1);
		vo.setMemberEmail("abc1234@naver.com");
		String check = "";
		
		if(mapper.bookLike(1).getMemberEmail() == null) {
			log.info("확인");
		}
		
	/*
			if(mapper.bookLike(1).getMemberId().equals(vo.getMemberId())) {
				mapper.deleteLike(vo);
				check =  mapper.bookLike(vo.getBookNum()).getLikeNum()+" "+flag;
			}else {
				mapper.insertLike(vo);
				flag = true;
				check =  mapper.bookLike(vo.getBookNum()).getLikeNum()+" "+flag;
			}	
	*/

	
	}

}
