package com.ryan.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.member.EmailCheckVO;
import com.ryan.function.EmailFunction;
import com.ryan.function.EmailThread;
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
	public boolean authenticationReady(EmailCheckVO email) {
		if(mapper.checkEmailAuthData(email) == 0) {  // 데이터가 없으면 0 있으면 1이상
			//데이터가 없으니까 데이터를 넣어줌
			email.setEmailCode(mail.getRandomCode());
			return mapper.insertEmailCode(email) == 1 ? true : false;
		} else {  // 데이터가 있으면
			email.setEmailCode(mail.getRandomCode());
			return mapper.updateAuthenticationCode(email) == 1 ? true : false;
		}		
		
	}


	@Override
	public boolean authenticationCodeSend(EmailCheckVO email) {
		return mail.authenticationCodeSend(email);
	}


	@Override
	public boolean authenticationCheck(EmailCheckVO email) {
		return mapper.authenticationCheck(email) == 1 ? true : false;
	}


	@Override
	public boolean authCompleteCheck(EmailCheckVO email) {
		try {
			return mapper.authCompleteCheck(email);
		} catch (Exception exception) {
			return false;
		}
	}


	@Override
	public boolean updateAuthComplete(EmailCheckVO email) {
		return mapper.updateAuthComplete(email) == 1 ? true : false;
	}


	@Override
	public void emailCodeDelete(EmailCheckVO email) {
		Thread thread = new Thread(new EmailThread(email, mapper));
		thread.start();
	}
	
	
	
	
	
	
	
}
