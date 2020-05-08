package com.ryan.domain.book;

import java.util.Date;

import lombok.Data;

@Data
public class BookAlarmVO {
	
	 // 고유번호 
    private int alarmNo;

    // 아이디 
    private String fkMemberAlarm;

    // 책번호 
    private int fkBookAlarm;

    // 알람 
    private int alarmCheck;		
    
    //0이면 알람 신청중
    //1이면 알람해주기
    //2이면 알람 중지 후 자동삭제
    
    //
    private String bookTitle;
    
    private int bookPbDate;

}
