package com.ryan.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberInterestsTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberInterestsMapper mapper;
	
	@Test
	public void insertTests() {
		
		int[] arr = {1,1,1,1,1,1,1};
		
		int result = mapper.insertInterests("abc1234@naver.com", arr);
		
		log.info("result : " + result);
		
	}
	
}
