package com.admin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.delivery.OrderDetailVO;
import com.ryan.domain.payment.OrderVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DeliveryManagementMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private DeliveryManagement mapper;
	
//	@Test
//	public void getOrderListTests() {
//		
//		mapper.getOrderList("").forEach(order -> log.info(order));
//		
//	}
	
//	@Test
//	public void updateOrderTrackingNumberTests() {
//		
//		OrderVO order = new OrderVO();
//		
//		order.setOrderNumber(68);
//		order.setOrderTrackingNumber(45412541);
//		
//		int result = mapper.updateTrackingNumber(order);
//		
//		log.info("결과는: " + result);
//	}
	
//	@Test
//	public void updateOrderStatusTests() {
//		
//		int[] orderNumber = {68,69};
//		String status = "결제 완료";
//		
//		int result = mapper.updateStatus(orderNumber, status);
//		
//		log.info("결과: " + result);
//		
//	}
	
	@Test
	public void getOrderDetailTests() {
		
		OrderDetailVO detail = mapper.getOrderDetail(69);
		
		detail.setDetailList(mapper.getOrderObject(69));
		
		log.info(detail);
		
		detail.getDetailList().forEach(details -> log.info(detail));
		
	}
	
}
