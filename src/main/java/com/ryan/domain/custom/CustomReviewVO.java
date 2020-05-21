package com.ryan.domain.custom;

import java.util.Date;

import lombok.Data;

@Data
public class CustomReviewVO {
	
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
    private String reviewRegdate;
    
    
    //회원닉네임
    private String memberNickName;
    
    //프로필
    private String memberProfile;
	
}
