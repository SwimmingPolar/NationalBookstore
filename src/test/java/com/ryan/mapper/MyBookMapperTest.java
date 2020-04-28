package com.ryan.mapper;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.book.MyLibVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBookMapperTest {
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;
/*	
	@Test
	public void readingBook() {
		MyLibVO vo = new MyLibVO();
		vo.setMemberEmail("abc1234@naver.com");
		log.info(mapper.readingBook(vo));
	}
	*/
	/*
	@Test
	public void insertList() {
		MyLibVO vo = new MyLibVO();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE,3);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time =
		df.format(cal.getTime());
		
	
		vo.setSubDate(cal.getTime());
		vo.setMemberEmail("abc1234@naver.com");
		vo.setBookNum(1);
		log.info("insert 결과 : " +mapper.insertList(vo));
	}
	
	*/
	@Test
	public void deleteList() {
		
		MyLibVO vo = new MyLibVO();
		
		vo.setMemberEmail("abc1234@naver.com");
		vo.setBookNum(1);
		log.info(mapper.deleteList(vo));
		
	}
}
