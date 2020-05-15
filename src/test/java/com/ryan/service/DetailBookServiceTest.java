package com.ryan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.BookLikeVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.mapper.DetailBookMapper;
import com.ryan.service.book.DetailBookService;

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
//		log.info(service.hashtag(197));
//	}
	
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
	
/*
	@Test
	public void insertLike() {
		boolean flag = false;
		BookLikeVO vo = new BookLikeVO();
		vo.setBookNum(1);
		vo.setMemberEmail("abc1234@naver.com");
		String check = "";
		
	*/
		
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

	@Test
	public void checkLike() {
		boolean flag= false;
		
		ArrayList<BookLikeVO> list = mapper.bookLikeList(210);
		
		MemberVO vo = new MemberVO();
		vo.setMemberEmail("abc1234@naver.com");
		if(vo!=null) {
			for(int i=0; i<list.size();i++) {
				if(list.get(i).getMemberEmail().equals(vo.getMemberEmail())) {
					flag = true;
					break;
				}
			}	
		}else {
			log.info("리턴값 " + flag);
		}
			
		log.info("리턴값  " + flag);
	}
	

}
