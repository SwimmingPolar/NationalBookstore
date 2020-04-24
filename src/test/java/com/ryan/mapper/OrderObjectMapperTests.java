package com.ryan.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.CartVO;
import com.ryan.domain.OrderVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderObjectMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderObjectMapper objMapper;
	
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper orderMaaper;
	
//	@Test
//	public void orderObjectInsertTests() {
//		
//		OrderVO order = new OrderVO();
//		order.setMemberEmail("abc12345@naver.com");
//		order.setOrderStatus("배송 준비중");
//		order.setOrderZipcode("123124");
//		order.setOrderAddress("서울특별시 종로구 종로종로");
//		order.setOrderDaddress("단성빌딩 5층입니다.");
//		order.setOrderComment("빠른 배송");
//		
//		int result = orderMaaper.insertOrder(order);
//		
//		ArrayList<CartVO> cartBuyList = new ArrayList<CartVO>();
//		
//		CartVO cart = new CartVO();
//		cart.setBookNum(3);
//		cart.setMemberEmail("abc1234@naver.com");
//		cart.setBookCount(12);
//		CartVO cart1 = new CartVO();
//		cart.setBookNum(2);
//		cart.setMemberEmail("abc1234@naver.com");
//		cart.setBookCount(11);
//		cartBuyList.add(cart1);
//		cartBuyList.add(cart);
//		log.info("orderNumber: " + order.getOrderNumber()); 
//		int result2 = objMapper.insertOrderObject(order.getOrderNumber(), cartBuyList);
//		
//		log.info("입력된 수 : " + result2);
//		
//	}
	
}