package com.ryan.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.mapper.AdminBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookMapperTest {
	
	@Setter(onMethod_ = {@Autowired})
	private AdminBookMapper mapper;
	
	@Test
	public void deleteBook() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(301);
		list.add(302);
		
		Map booknum = new HashMap<>();
		
		booknum.put("numberlist", list);
		log.info(mapper.deleteBook(booknum));
	}
}
;