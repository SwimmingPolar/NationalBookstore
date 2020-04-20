package com.ryan.mapper;

import java.text.SimpleDateFormat;
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
	
//	@Test
//	public void memberSignUpTests() {
//		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		
//		MemberVO vo = new MemberVO();
//		vo.setMemberEmail("abc12345@naver.com");
//		vo.setMemberPw("abc1234");
//		vo.setMemberNickName("홍길동1");
//		vo.setMemberZipcode("00872");
//		vo.setMemberAddress("서울 특별시 종로구 종로동");
//		vo.setMemberDaddress("단성빌딩");
//		vo.setMemberTel("010-1111-1111");
//		vo.setMemberAdmin(1);
//		log.info("member Insert");
//		log.info("리턴값: " + mapper.memberSignUp(vo)); // 1리턴
//		
//	}
	
	//아이디 중복체크
	@Test
	public void signUpCheck() {
		
		MemberVO vo = new MemberVO();
		vo.setMemberNickName("홍길동");
		log.info("실행");
		log.info("리턴값: " + mapper.signUpCheck(vo));
		log.info("ddsdaf");
	}
	
	
	
	
}
