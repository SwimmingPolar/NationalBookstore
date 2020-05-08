package com.ryan.domain.member;

import lombok.Data;

@Data
public class FollowVO {
	
    // 고유번호 
    private int followNum;

    // 요청자 
    private String fkMemberFollow1;

    // 요청받는자 
    private String fkMemberFollow2;
	
    //닉네임
    private String memberNickName;
    
}
