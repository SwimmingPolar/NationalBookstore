package com.ryan.domain.payment;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
    
    // 주문번호 
    private int orderNumber;

    // 회원아이디 
    private String memberEmail;

    // 주문날짜 
    private String orderDate;

    // 배송진행상태 
    private String orderStatus;

    // 우편번호 
    private String orderZipcode;

    // 주소 
    private String orderAddress;

    // 상세주소 
    private String orderDaddress;

    // 코멘트 
    private String orderComment;

    // 결제 방식 
    private String orderPaymentMethod;

    // 운송장 번호 
    private int orderTrackingNumber;
    
    //총합계 금액
    private int sum;
    
}
