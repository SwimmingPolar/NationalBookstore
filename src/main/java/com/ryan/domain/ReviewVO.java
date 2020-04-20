package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	  // review_Num 
    private int reviewNum;

    // 책번호 
    private int bookNum;

    // 회원아이디 
    private String memberEmail;

    // 제목 
    private String reviewTitle;

    // 내용 
    private String reviewContent;

    // 작성날짜 
    private Date reviewRegdate;
}
