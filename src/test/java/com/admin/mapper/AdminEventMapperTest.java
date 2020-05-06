package com.admin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.book.AdminBestListVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminEventMapperTest {

	@Setter(onMethod_ = {@Autowired})
	private AdminEventMapper mapper;
	
	@Test
	public void pushBook() {
		AdminBestListVO vo = new AdminBestListVO();
		
		vo.setCategoryNum(1);
		vo.setBookNum(197);
				
		log.info("결과 " +mapper.pushBook(vo));
	}
}
