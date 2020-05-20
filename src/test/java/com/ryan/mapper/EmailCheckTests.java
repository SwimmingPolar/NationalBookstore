package com.ryan.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.member.EmailCheckVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/security-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class EmailCheckTests {
	
	@Setter(onMethod_ = @Autowired)
	private EmailMapper mapper;
	
	@Test
	public void tests() {
		EmailCheckVO email = new EmailCheckVO();
		email.setMemberEmail("pursue503@naver.com");
		
		boolean result = mapper.authCompleteCheck(email);
		
		log.info("result : " + result);
		
	}
	

	
}
