package com.ryan.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.EmailCheckVO;
import com.ryan.function.EmailFunction;
import com.ryan.mapper.EmailMapper;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailMapper mapper;
	
	private EmailFunction mail;

	
	
	@Override
	public EmailCheckVO insertEmailCode(EmailCheckVO email) {
		email.setEmailCode(mail.getRandomCode());
		email.setEmailNum(mapper.insertEmailCode(email));
		
		return email;
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
