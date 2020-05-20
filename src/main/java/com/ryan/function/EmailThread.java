package com.ryan.function;

import com.ryan.domain.member.EmailCheckVO;
import com.ryan.mapper.EmailMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class EmailThread implements Runnable {
	
	private EmailMapper mapper;
	
	private EmailCheckVO email;
	
	public EmailThread(EmailCheckVO email, EmailMapper mapper) {
		super();
		this.email = email;
		this.mapper = mapper;
	}


	@Override
	public void run() {
		
		try {
			Thread.sleep(1000*10*60*3); //1000*60*3
			
			try {
				if(!mapper.authCompleteCheck(email)) {
					mapper.emailCodeDelete(email);
				} 
			} catch (NullPointerException e) {
				mapper.emailCodeDelete(email);
			}
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
