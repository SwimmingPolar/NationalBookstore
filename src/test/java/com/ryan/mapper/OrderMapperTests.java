package com.ryan.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.payment.CartVO;
import com.ryan.domain.payment.OrderVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper mapper;
	
//	@Test 테스트완료.
//	public void orderInsertTest() {
//		
//		OrderVO order = new OrderVO();
//		order.setMemberEmail("abc12345@naver.com");
//		order.setOrderStatus("배송 준비중");
//		order.setOrderZipcode("123124");
//		order.setOrderAddress("서울특별시 종로구 종로종로");
//		order.setOrderDaddress("단성빌딩 5층입니다.");
//		order.setOrderComment("빠른 배송");
//		
//		int result = mapper.insertOrder(order);
//		log.info("insert 완료 결과는 : " + result);
//	}
	
}
