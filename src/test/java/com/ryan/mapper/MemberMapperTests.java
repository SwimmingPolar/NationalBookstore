package com.ryan.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	@Test
	public void memberSignUpTests() {
		
		MemberVO vo = new MemberVO();
		vo.setMemberId("abc1234@naver.com");
		vo.setMemberPw("abc1234");
		vo.setMemberNickName("홍길동");
		vo.setMemberZipcode("00872");
		vo.setMemberAddress("서울 특별시 종로구 종로동");
		vo.setMemberDaddress("단성빌딩");
		vo.setMemberTel("010-1111-1111");
		vo.setMemberSub(new Date());
		vo.setMemberAdmin(1);
		
		log.info(mapper.memberSignUp(vo));
		
	}
	
}
