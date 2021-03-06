package com.ryan.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.member.MemberVO;
import com.ryan.service.member.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
//	@Test
//	public void SignUpCheck() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberId("abc1234");
//		log.info("회원 아이디, 닉네임 중복체크 : " + service.signUpCheck(member));
//	}
	
	//회원가입 테스트 공백, null
//	@Test
//	public void memberSignUp() {
//		
//		MemberVO vo = new MemberVO();
//		vo.setMemberEmail("abc1234123@naver.com");
//		vo.setMemberPw("abc1234");
//		vo.setMemberNickName("홍길동123");
//		vo.setMemberZipcode("00872");
//		vo.setMemberAddress("종로종로");
//		vo.setMemberDaddress("서울특별시 종로구 종로종로~");
//		vo.setMemberTel("010-1111-1111");
//		vo.setMemberAdmin(1);
//		
//		log.info(service.memberSignUp(vo));
//		
//		
//	}
	
	//로그인
	@Test
	public void memberSignInTest() {
		
		MemberVO member = new MemberVO();
		member.setMemberEmail("abc1234@naver.com");
		member.setMemberPw("abc1234");
		
		boolean result =  service.memberSignIn(member);
		
		if(result) {
			log.info("로그인 성공 ");
		} else {
			log.info("로그인 실패");
		}
		
	}
	
}
