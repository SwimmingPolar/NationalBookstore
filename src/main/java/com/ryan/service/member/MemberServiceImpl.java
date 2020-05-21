package com.ryan.service.member;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ryan.domain.member.EmailCheckVO;
import com.ryan.domain.member.MemberAllDataVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.function.EmailFunction;
import com.ryan.mapper.EmailMapper;
import com.ryan.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private PasswordEncoder pwencoder;
	
	@Setter(onMethod_ = {@Autowired})
	private EmailMapper emailMapper;
	
	@Setter(onMethod_ = {@Autowired})
	private EmailFunction mail;
	
	@Override
	public boolean memberSignUp(MemberVO member) {
		
		//아이디 이메일형식
		Pattern id = Pattern.compile("^[\\d\\w]+@(=?.*?[\\w]+)[\\d\\w]*\\.[\\w]+(\\.[\\w]+){0,1}$");
		Matcher idMatcher = id.matcher(member.getMemberEmail());
		Pattern pw = Pattern.compile("^(?=.*?[^\\s])[\\w\\d]{4,12}$");
		Matcher pwMatcher = pw.matcher(member.getMemberPw());
		Pattern nickName = Pattern.compile("^[a-z][\\d\\w]{3,11}");
		Matcher nickMatcher = nickName.matcher(member.getMemberNickName());
		
		if(!idMatcher.find())return false;
		if(!pwMatcher.find()) return false;
		if(!nickMatcher.find()) return false;
		
		//유효성 검증 통과하면 비밀번호 암호화
		member.setMemberPw(pwencoder.encode(member.getMemberPw()));
		
		try {
			//객체를 만들면안되는데 다른거 수정하기가 너무힘들어서 객체생성합니다.
			EmailCheckVO email = new EmailCheckVO();
			email.setMemberEmail(member.getMemberEmail());
			if(emailMapper.authCompleteCheck(email)) {
				return mapper.memberSignUp(member) == 2 ? true : false;
			} else { 
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	
	@Override
	public boolean signUpCheck(MemberVO member) {
		return mapper.signUpCheck(member) == 0 ? true : false;
	}


	@Override
	public boolean memberUpdate(MemberVO member, ArrayList<MultipartFile> files, HttpServletRequest request) {
		
		Pattern pw = Pattern.compile("^(?=.*?[^\\s])[\\w\\d]{4,}$");
		Matcher pwMatcher = pw.matcher(member.getMemberPw());
		if(!pwMatcher.find()) return false;
		//비밀번호암호화
		member.setMemberPw(pwencoder.encode(member.getMemberPw()));
		
		String path = request.getSession().getServletContext().getRealPath("//") + "\\resources\\member\\profile\\";
		log.info(path);
		for(MultipartFile file : files) {
			
			log.info(file.getOriginalFilename());
			File save = new File(path,member.getMemberEmail() + ".jpg");
			
			try {
				file.transferTo(save);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
		
		member.setMemberProfile("/resources/member/profile/" + member.getMemberEmail() + ".jpg");
		
		return mapper.memberUpdate(member) == 1 ? true : false;
	}

	@Override
	public boolean memberSignIn(MemberVO member) {
		return mapper.memberSignIn(member) == 1 ? true : false;
	}



	@Override
	public boolean memberBanCheck(MemberVO member) {
		return mapper.memberBanCheck(member) >= 1 ? true : false;
	}


	@Override
	public MemberVO getLoginMemberInfo(MemberVO member) {
		return mapper.getLoginMemberInfo(member);
	}


	@Override
	public boolean forgotPassword(MemberVO member) {
		
		String randomPw = mail.getRandomCode();
		member.setMemberPw(pwencoder.encode(randomPw));
		
		if(mapper.forgotPassword(member) == 1) { //비밀번호 변경성공
			if(mail.forgotPassword(member.getMemberEmail(), randomPw)) {
				return true;
			}
		}
		
		return false;
	}


	@Override
	public MemberAllDataVO getMemberAllData(MemberVO member) {	
		int count = 0;
		int[] orderNumArr = mapper.getMemberOrderNumber(member);
		if(orderNumArr.length >0) {
			count = mapper.myRealBookBuyCount(orderNumArr);
		}
		return new MemberAllDataVO(mapper.myLibCount(member),
				mapper.myPostCount(member),
				mapper.myfollowCount(member),
				count);
	}


	@Override
	public boolean memberPasswordCheck(MemberVO member) {
		
		if(pwencoder.matches(member.getMemberPw(), mapper.getMemberPassword(member))) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean memberDelete(MemberVO member) {
		try {
			mapper.deleteMemberData(member);
			
			mapper.deleteMemberBookMark(mapper.getMemberReadBookNO(member));
			mapper.deleteMemberReadBook(member);
			mapper.deleteMemberOrderObject(mapper.getMemberOrderNumber(member));
			mapper.deleteMemberOrderNumber(member);
			mapper.deleteMemberCart(member);
			mapper.deleteMember(member);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}


	@Override
	public void memememe(MemberVO member) {
		mapper.subAuth(member);
	}
	
	
	

}
