package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MyLibVO {
	   // 서재고유번호 
    private int libNum;

    // 회원아이디 
    private String memberEmail;

    // 책 고유번호 
    private int bookNum;

}
