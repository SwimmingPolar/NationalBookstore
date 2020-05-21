package com.ryan.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.book.BookAlarmVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MyBookAlarmMapperTests {

	@Setter(onMethod_ = {@Autowired})
	private MyBookAlarmMapper mapper;
	
//	@Test
//	public void showAlarm() {
//		String email = "abc1234@naver.com";
//		ArrayList<BookAlarmVO> list = mapper.showAlarm(email);
//		for(BookAlarmVO vo : list) {
//			log.info(vo);
//		}
//	}
	
	@Test
	public void checkAlarm() {
		log.info(mapper.checkAlarm("loody00@naver.com"));
	}
}
