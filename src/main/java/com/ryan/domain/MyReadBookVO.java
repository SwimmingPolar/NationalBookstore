package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MyReadBookVO {
	

    // 고유번호 
    private int readNum;

    // 회원아이디 
    private String memberEmail;

    // 책 고유번호 
    private int bookNum;
    
 // 대여일자 
    private String readDate;

}
