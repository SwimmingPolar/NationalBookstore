package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.book.BookAlarmVO;

public interface MyBookAlarmMapper {

	public int requestAlarm(BookAlarmVO vo); 	//알람요청
	
	public ArrayList<BookAlarmVO> showAlarm(String email); 	//알람 보여주기
	
	public ArrayList<BookAlarmVO> checkList();	// 알람 구분 체크
	
	public int changeNO(int AlarmNO);
	
	public int deleteAlarm(int AlarmNO);
}
