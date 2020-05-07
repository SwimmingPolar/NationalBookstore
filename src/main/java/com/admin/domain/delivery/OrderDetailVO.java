package com.admin.domain.delivery;

import java.util.ArrayList;
import java.util.Date;

import com.ryan.domain.payment.OrderObjectVO;

import lombok.Data;

@Data
public class OrderDetailVO {
	
    // 주문번호 
    private int orderNumber;

    // 회원아이디 
    private String memberEmail;

    // 주문날짜 
    private Date orderDate;

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
    
    private ArrayList<OrderObjectVO> detailList;
	
	
}
