package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	 // 아이디 
    private String memberEmail;

    // 비밀번호 
    private String memberPw;

    // 닉네임 
    private String memberNickName;

    // 우편번호 
    private String memberZipcode;

    // 주소 
    private String memberAddress;

    // 상세주소 
    private String memberDaddress;

    // 전화번호 
    private String memberTel;

    // 구독 
    private Date memberSub;
    
    // 권한 
    private int memberAdmin;
	
    
}
