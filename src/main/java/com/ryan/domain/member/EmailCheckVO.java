package com.ryan.domain.member;

import lombok.Data;

@Data
public class EmailCheckVO {
	
    // 고유번호 
    private int emailNum;

    // 인증용 이메일 
    private String memberEmail;

    // 인증번호 
    private String emailCode;

    // 인증완료 
    private int emailAuthComplete;
    
    
}
