package com.ryan.domain.member;

import lombok.Data;

@Data
public class MemberAuthVO {
	
    // 아이디 
    private String memberEmail;

    // 권한 
    private String auth;
	
}
