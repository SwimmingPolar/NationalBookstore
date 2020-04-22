package com.ryan.domain;

import lombok.Data;

@Data
public class CartVO {
	
	// 고유번호 
    private int cartNum;

    // 책번호 
    private int bookNum;

    // 회원아이디 
    private String memberEmail;

    // 구매수량 
    private int bookCount;
	//책 가격
    private int bookPrice;
    
    
    
}
