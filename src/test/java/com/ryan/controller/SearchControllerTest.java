package com.ryan.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.admin.mapper.NoticeBoardMapper;
import com.ryan.domain.book.ReviewVO;
import com.ryan.mapper.ReviewMapper;

import lombok.extern.log4j.Log4j;

/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})*/
@Log4j
public class SearchControllerTest {
	
	/*@Autowired
	private WebApplicationContext ctx;
	@Autowired
	private ReviewService service;*/
	@Autowired
	private ReviewMapper mapper;
	
	@Autowired
	private NoticeBoardMapper nmapper;
	
	//private MockMvc mockMvc;
	
	/*@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}*/
	
	@SuppressWarnings("unused")
	@Test
	public void test() throws IOException, SQLException{
		ReviewVO review=new ReviewVO();
		int bookNum=22;
		review.setBookNum(bookNum);
		review.setReviewTitle("test");
		review.setReviewContent("tttttest");
		review.setMemberEmail("test@email.com");
		
		//review=null;
		boolean flag;
		System.out.println(mapper.test());
		//flag=mapper.insertReview(review)>0?true:false;

		//assertTrue(flag);
		//assertNull(review);
		//assertNull(mapper.insertReview(review));

		
	}

}
