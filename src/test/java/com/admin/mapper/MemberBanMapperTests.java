package com.admin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.member.MemberBanVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberBanMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberBanMapper mapper;
	
	
//	@Test
//	public void insertinsertMemberBanTests() {
//		
//		MemberBanVO memberBan = new MemberBanVO();
//		memberBan.setMemberEmail("abc1234@naver.com");
//		memberBan.setBanReason("욕설");
//		memberBan.setBanPeriod(7);
//		
//		int result = mapper.insertMemberBan(memberBan);
//		log.info("결과: " + result);
//	}
	
//	@Test
//	public void getBanList() {
//		
//		mapper.getBanList().forEach(ban -> log.info(ban));
//		
//	}
	
//	@Test
//	public void getBanHistory() {
//		
//		mapper.getBanHistory().forEach(ban -> log.info(ban));
//	}
	
	@Test
	public void getTodayMemberLiberationList() {
		
//		mapper.getTodayMemberLiberationList().forEach(ban -> log.info(ban)); //불러오기 테스트
		
		//해제
		
		mapper.memberLiberation(mapper.getTodayMemberLiberationList());
		
	}
	
}
