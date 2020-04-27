package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayResponseVO {
	
	//response 로 받는것들
	private String tid; // 결제 고유 번호 20자
	private String next_redirect_pc_url; // pc
	private Date created_at;
	
}
