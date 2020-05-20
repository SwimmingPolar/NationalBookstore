package com.ryan.service.book;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.ryan.domain.book.BookAlarmVO;

public interface MyBookAlarmService {

	public Boolean requestAlarm(BookAlarmVO vo, String memberEmail);	//알람 요청
	
	public ArrayList<BookAlarmVO> showAlarm(Authentication auth); 	//알람 보여주기
	
	//매일 당일 날짜 출판 예정인 책 알람구분 변경
	public void checkDay();
}
