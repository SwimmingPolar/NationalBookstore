package com.ryan.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"
	
})
@Log4j
public class MemberControllerTests {
	
	//
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	//가짜 mvc 테스트용..
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void signUpCheck() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/member/signUpCheck")
//				.param("memberId", "abc1234"))
//				.andReturn()
//				.getModelAndView()
//				.getModel());
//	}
	
	@Test
	public void memeberSignUp() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/member/signUp")
				.param("memberId", "abc1234554@naver.com")
				.param("memberPw", "aaa1111")
				.param("memberNickName", "odkqosd10")
				.param("memberZipcode", "01111")
				.param("memberAddress", "서울서울서울!!")
				.param("memberDaddress", "서울특별시 종로구 종로동")
				.param("memberTel", "010-1111-1111")
				.param("memberSub", "2020/01/01")
				.param("memberAdmin", "1"))
				.andReturn().getModelAndView().getViewName();
		
		log.info("회원가입 결과: " +  resultPage);
	}
	
	
}
