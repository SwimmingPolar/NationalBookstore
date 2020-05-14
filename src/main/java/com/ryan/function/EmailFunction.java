package com.ryan.function;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.ryan.domain.member.EmailCheckVO;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class EmailFunction {
	
	//메일 보내기용 클래스 입니다.
	private Properties props;
	private final String gmail_Id;
	private final String gmail_Pw;
	
	
	public EmailFunction() {
		this.gmail_Id = "ryanbooks.web@gmail.com";
		this.gmail_Pw = "ryanbooks";
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
		
	}
	
	
	public boolean authenticationCodeSend(EmailCheckVO email) {
		
		boolean flag = false;
		
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmail_Id, gmail_Pw);
			}
			
			
		};
		
		
		Session session = Session.getDefaultInstance(this.props,auth);
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			
			msg.addHeader("content-Type", "text/html; charset=UTF-8");
			
			InternetAddress from = new InternetAddress("MemoryBoost");
			
			msg.setFrom(from);
			//제목
			msg.setSubject("ryanBooks! 이메일 인증!" , "UTF-8");
			//내용 나중에 시간되면 좀..있어보이게 수정
			msg.setContent("<h1>인증코드는 : " + email.getEmailCode() + "입니다 </h1>" , "text/html; charset=UTF-8");
			
			msg.setSentDate(new Date());
			
			//받는사람
			
			InternetAddress to = new InternetAddress(email.getMemberEmail());
			
			msg.setRecipient(Message.RecipientType.TO, to);
			
			//메일보내기
			
			Transport.send(msg);
			
			log.info("메일 보내기 성공");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		
		return flag;
		
	} // 이메일 인증 end
	
	//메소드명 나중에 다시 설정.
	public void userIdSend(String member_Id , String member_Email , String member_Name) {
		
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmail_Id, gmail_Pw);
			}
			
			
		};
		
		
		Session session = Session.getDefaultInstance(this.props,auth);
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			
			msg.addHeader("content-Type", "text/html; charset=UTF-8");
			
			InternetAddress from = new InternetAddress("MemoryBoost");
			
			msg.setFrom(from);
			//제목
			msg.setSubject("Memory Boost! 아이디 찾기!" , "UTF-8");
			//내용 나중에 시간되면 좀..있어보이게 수정
			msg.setContent("<h1>" + member_Name + "님의 아이디는: " + member_Id + "입니다" + "</h1>", "text/html; charset=UTF-8");
			
			msg.setSentDate(new Date());
			
			//받는사람
			
			InternetAddress to = new InternetAddress(member_Email);
			
			msg.setRecipient(Message.RecipientType.TO, to);
			
			//메일보내기
			
			Transport.send(msg);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//비밀번호
	
	public void sendUserPW(String member_Id , String member_Email , String code) {
		
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmail_Id, gmail_Pw);
			}
			
			
		};
		
		
		Session session = Session.getDefaultInstance(this.props,auth);
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			
			msg.addHeader("content-Type", "text/html; charset=UTF-8");
			
			InternetAddress from = new InternetAddress("MemoryBoost");
			
			msg.setFrom(from);
			//제목
			msg.setSubject("Memory Boost! 비밀번호 찾기" , "UTF-8");
			//내용 나중에 시간되면 좀..있어보이게 수정
			msg.setContent("<h1>" + member_Id + "님의 비밀번호는: " + code + "입니다" + " 보안을 위해 비밀번호를 꼭 변경해주세요!" + "</h1>", "text/html; charset=UTF-8");
			
			msg.setSentDate(new Date());
			
			//받는사람
			
			InternetAddress to = new InternetAddress(member_Email);
			
			msg.setRecipient(Message.RecipientType.TO, to);
			
			//메일보내기
			
			Transport.send(msg);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//랜덤 코드 생성
	public String getRandomCode() {
		
		StringBuffer checkedCode = new StringBuffer();
		
		Random rn = new Random();
		
		//12자리로함
		
		for(int i=0; i<12; i++) {
			
			int code = rn.nextInt(3);
			
			switch(code) {
			
			case 0:
				
				//a-z
				checkedCode.append((char) ((int) (rn.nextInt(26)) + 97 ));
				
				break;
				
			case 1 :
				
				//A-Z
				checkedCode.append((char) ((int) (rn.nextInt(26)) + 65));
				
				break;
				
			case 2: 
				
				//0-9
				
				checkedCode.append(rn.nextInt(10));
				break;
			
			}
			
		}
		
		return checkedCode.toString();
	}
	
}
