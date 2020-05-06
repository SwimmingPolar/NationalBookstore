package com.admin.domain.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberBanVO {
	// 고유번호 
    private int banNum;

    // 아이디 
    private String memberEmail;

    // 정지 사유 
    private String banReason;

    // 정지해제 날짜 
    private Date banReleaseDate;

    // 정지 체크 
    private int banCheck;

    // 정지 기간 
    private int banPeriod;
}
