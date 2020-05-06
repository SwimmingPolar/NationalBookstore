package com.ryan.domain.member;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentVO {
	
    // 정기결제 
    private int paymentNum;

    // 아이디 
    private String memberEmail;

    // 정기결제SID키 
    private String memberSid;

    // 다음 결제 날짜 
    private Date memberNextPayment;

    // 정기 결제 
    private int memberPaymentCheck;
	
}
