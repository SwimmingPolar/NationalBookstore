package com.ryan.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.mapper.EnquiryBoardMapper;
import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.ReviewVO;
import com.ryan.mapper.ReviewMapper;
import com.ryan.service.main.ReviewService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class SearchControllerTest {
	@Setter(onMethod_ = {@Autowired})
	private ReviewMapper mapper;
	
	
	@Setter(onMethod_ = {@Autowired})
	private EnquiryBoardMapper emapper;
	
	@Setter(onMethod_ = {@Autowired})
	private ReviewService service;
	
	
	  @Test public void insertReviewTests() {
	  
	  ReviewVO review = new ReviewVO();
	  
	  review.setBookNum(682); 
	  review.setMemberEmail("lee2nanna@naver.com");
	  review.setReviewTitle("테스트용 제목입니다."); 
	  review.setReviewContent("테스트용 내용입니다.");
	  
	  //int result = mapper.insertReview(review);
	  
	  int grade=4;
	  
	  //boolean result =service.insertReview(review,grade);
	  //log.info("result :  " + 	mapper.insertReview(review));
	  
		BookGradeVO vo=new BookGradeVO();
		vo.setBookNum(review.getBookNum());
		vo.setMemberEmail(review.getMemberEmail());
		vo.setGradeScore(grade);
		
		//log.info("result :  " + mapper.insertGrade(vo));
	  //log.info("result :  " + result);
	  
	  }
	 
	
	
	
	  @Test 
	  public void inserten() { 
			/*
			 * EnquiryBoardVO eq=new EnquiryBoardVO(); eq.setBoardContent("내용");
			 * eq.setMemberEmail("abc1234@naver.com"); eq.setBoardTitle("테스트");
			 * eq.setBoardState(1);
			 * 
			 * int result = emapper.insertEq(eq);
			 */
	  //service.insertReview(review);

		  emapper.selectEqList("lee2nanna@naver.com").forEach(review -> log.info(review));
	  }
}
