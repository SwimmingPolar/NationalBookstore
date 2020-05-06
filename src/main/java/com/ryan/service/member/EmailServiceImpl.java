package com.ryan.service.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.member.EmailCheckVO;
import com.ryan.function.EmailFunction;
import com.ryan.mapper.EmailMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailMapper mapper;
	
	@Autowired
	private EmailFunction mail;

	
	
	@Override
	public boolean insertEmailCode(EmailCheckVO email) {
		email.setEmailCode(mail.getRandomCode());
		
		
		return mapper.insertEmailCode(email) == 1 ? true : false;
	}


	@Override
	public boolean authenticationCodeSend(EmailCheckVO email) {		
		return mail.authenticationCodeSend(email);
	}


	@Override
	public boolean authenticationCheck(EmailCheckVO email) {
		return mapper.authenticationCheck(email) == 1 ? true : false;
	}
	
	
	
	
	
	
	
}