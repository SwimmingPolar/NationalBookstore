package com.ryan.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.member.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private PasswordEncoder pwEncoder;
	
	
//	@Test
//	public void memberSignUpTests() {
//		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		
//		MemberVO vo = new MemberVO();
//		vo.setMemberEmail("bbb1234@Naver.com");
//		vo.setMemberPw(pwEncoder.encode("bbb1111"));
//		vo.setMemberNickName("dfdsfasdf");
//		vo.setMemberZipcode("00872");
//		vo.setMemberAddress("서울 특별시 종로구 종로동");
//		vo.setMemberDaddress("단성빌딩");
//		vo.setMemberTel("010-1111-1111");
//		log.info("member Insert");
//		log.info("리턴값: " + mapper.memberSignUp(vo)); // 2리턴
//		
//	}

	
//	//아이디 중복체크
//	@Test
//	public void signUpCheck() {
//		
//		MemberVO vo = new MemberVO();
//		vo.setMemberNickName("홍길동");
//		log.info("실행");
//		log.info("리턴값: " + mapper.signUpCheck(vo));
//		log.info("ddsdaf");
//	}
	
//	//로그인 - 완료
//	@Test
//	public void signInTest() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("bbb1234@Naver.com");
//		member.setMemberPw("bbb1111");
//		
//		
//		MemberVO resultMember = mapper.getLoginMemberInfo(member);
//		log.info(resultMember);
//		resultMember.getMemberAuthList().forEach(auth -> log.info(auth));
//	}
	
	//회원정보 업데이트 -완료
//	@Test
//	public void memberUpdate() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("abc1234@naver.com");
//		member.setMemberZipcode("09090");
//		int result = mapper.memberUpdate(member);
//		
//		log.info("업데이트 리턴 값: " + result);
//		
//	}
	
	
//	//회원탈퇴
//	@Test
//	public void memberDelete() {
//		
//		
//		
//	}
	
//	//정지유효성?
//	@Test
//	public void memeberBanCheckTests() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("abc1234@naver.com");
//		
//		int result = mapper.memberBanCheck(member);
//		
//		log.info("결과: " + result);
//	}
	
//	@Test
//	public void getMemberOrderNumberTests() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("abc1234@naver.com");
//		
//		int[] orderNumber = mapper.getMemberOrderNumber(member);
//		
//		for(int i=0; i<orderNumber.length; i++) {
//			log.info(orderNumber[i]);
//		}
//		
//		
//	}
	
//	@Test
//	public void getReadBookCount() {
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail("pursue503@naver.com");
//		
//		int[] arr = mapper.getMemberOrderNumber(member);
//		
//		int result = mapper.myRealBookBuyCount(arr);
//		
//		log.info(result);
//			
//	}
	
	@Test
	public void deleteTest() {
		
		MemberVO member = new MemberVO();
		member.setMemberEmail("abc1234554@naver.com");
		
		mapper.deleteMemberData(member);
		
		mapper.deleteMemberBookMark(mapper.getMemberReadBookNO(member));
		mapper.deleteMemberReadBook(member);
		mapper.deleteMemberOrderObject(mapper.getMemberOrderNumber(member));
		mapper.deleteMemberOrderNumber(member);
		mapper.deleteMemberCart(member);
		mapper.deleteMember(member);
		
		
	}
	
}
