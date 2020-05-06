package com.admin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.revenue.SearchDateVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberManagementMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberManagementMapper mapper;
	
//	@Test
//	public void getMemberSignupDateTests() {
//		
//		mapper.getMemberSignupDate().forEach(string -> log.info(string));
//		
//	}
	
//	@Test -완료
//	public void getMemberSignupCountTests() {
//		
//		SearchDateVO search = new SearchDateVO();
//		
////		search.setChoiceDate("2020-05");
//		search.setStartDate("2020-04-25");
//		search.setEndDate("2020-05-07");
//		
//		
//		mapper.getMemberSignupCount(search).forEach(member -> log.info(member));
//		
//	}
	
//	@Test
//	public void getSubscriptionCountTests() {
//		
//		SearchDateVO search = new SearchDateVO();
//		
//		search.setChoiceDate("2020-05");
//		mapper.getSubscriptionCount(search).forEach(sub -> log.info(sub));
//		
//	}
	
//	@Test
//	public void getSubscriptionMemberTests() {
//		
//		mapper.getSubscriptionMember().forEach(sub -> log.info(sub));
//		
//	}
	
}
