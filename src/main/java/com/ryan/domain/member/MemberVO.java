package com.ryan.domain.member;

import java.util.Date;
import java.util.List;

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

    // 가입날짜 
    private Date memberSignupDate;

    // 사용 
    private boolean memberEnabled;
    
    private List<MemberAuthVO> memberAuthList;
}
