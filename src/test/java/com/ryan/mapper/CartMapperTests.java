package com.ryan.mapper;

import java.util.ArrayList;

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
public class CartMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private CartMapper mapper;
	
//	@Test
//	public void removeAllTest() {
//		
//		log.info(mapper.removeAll("abc1234@naver.com"));
//		
//	}
	
//	@Test
//	public void getCartList() {
//		
//		mapper.getCartList("abc1234@naver.com").forEach(cart -> log.info(cart));
//		
//	}
	
	@Test
	public void cartBuyList() {
		
		int[] cartNumList = {2,3,4,5};
		
		log.info("실행");
		mapper.cartBuyList(cartNumList).forEach(cart -> log.info(cart));
	}
	
}
