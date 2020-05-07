package com.admin.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.revenue.BookRevenueVO;
import com.admin.domain.revenue.SearchDateVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RevenueMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private RevenueMapper mapper;
	
//	@Test
//	public void getRegularPaymentRevenueTests() {
//		
//		RevenueDateVO reDate = new RevenueDateVO();
//		reDate.setStartDate("2020-04-01");
//		reDate.setEndDate("2020-05-03");
//		
//		mapper.getRegularPaymentRevenue(reDate).forEach(VO -> log.info(VO));
//		
//	}
	
//	@Test
//	public void getPaymentMonthData() {
//		
//	}
	
//	@Test
//	public void getBookPaymentRevenueDate() {
//		
//		mapper.getBookPaymentRevenueDate().forEach(date -> log.info(date));
//
//		
//	}
	
	@Test
	public void getBookPaymentRevenue() {
		
		SearchDateVO reDate = new SearchDateVO();
		reDate.setStartDate("2020-04-01");
		reDate.setEndDate("2020-05-03");
		
		mapper.getBookPaymentRevenue(reDate).forEach(date -> log.info(date));
		
	}
	
}
