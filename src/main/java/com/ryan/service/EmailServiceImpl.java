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
