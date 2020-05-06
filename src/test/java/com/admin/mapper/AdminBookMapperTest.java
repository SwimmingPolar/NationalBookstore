package com.admin.mapper;

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
public class AdminBookMapperTest {
	
	@Setter(onMethod_ = {@Autowired})
	private AdminBookMapper mapper;
/*	
	@Test
	public void bestReader() {
		String date = "%04%";
		log.info("결과 : " +mapper.bestReader(date));
	}*/
	
	@Test
	public void statusLike() {
		log.info("결과 : "+mapper.statusLike());
	}
	
	
	@Test
	public void statusLookup() {
		log.info("결과 : "+mapper.statusLookup());
	}
}
