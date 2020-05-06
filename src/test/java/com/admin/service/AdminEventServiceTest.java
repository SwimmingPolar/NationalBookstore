package com.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.book.AdminBestListVO;
import com.admin.mapper.AdminEventMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminEventServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private AdminEventMapper mapper;
	
	@Test
	public void pushBook() {
		int count = mapper.countBook();
		List<AdminBestListVO> list = mapper.checkBook();
		boolean flag = false;
		AdminBestListVO booknum = new AdminBestListVO();
		
		booknum.setBookNum(197);
		booknum.setCategoryNum(1);
		
		if(count < 6) {
			if(!list.equals("") || list != null) {
				for(int i=0; i<list.size();i++) {
					if(booknum.getBookNum()==list.get(i).getBookNum()) {
						flag=true;
						break;
					}
				}
				if(flag) {
					log.info("같은책 존재");
				}else {
					mapper.pushBook(booknum);
				}
			}
		}else {
			log.info("count 확인");
		}
		
	}
	
	
	/*
	@Test
	public void deleteBook() {
		
		int[] deletenum = {198};		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int number : deletenum) {
			list.add(number);
		}
		
		Map map = new HashMap();
		map.put("deletenum", list);	
		
		log.info("결과 " +mapper.deleteBook(map));
		
	}*/
}
