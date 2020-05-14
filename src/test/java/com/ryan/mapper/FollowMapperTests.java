package com.ryan.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.domain.member.MemberBanVO;
import com.ryan.domain.member.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FollowMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private FollowMapper mapper;
	
	@Test
	public void insertFollowTests() {
		
		
		
		if(mapper.followCheck("abc12345@naver.com", "abc1234@naver.com") != 1) {
			int result = mapper.insertFollow("abc12345@naver.com","abc1234@naver.com" );
			
			log.info("결과: " + result);
		} else {
			log.info("실패");
		}
		
	}
	
//	@Test
//	public void getMyFollowingTests() {
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("abc1234@naver.com");
//		
//		mapper.getMyFollowing(member).forEach(follow -> log.info(follow));
//	}
	
//	@Test
//	public void getMyFollowerTests() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("abc12345@naver.com");
//		mapper.getMyFollower(member).forEach(follow -> log.info(follow));
//		
//	}
	
}
