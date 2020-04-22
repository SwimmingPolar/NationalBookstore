package com.ryan.domain;

import lombok.Data;

@Data
public class OrderObjectVO {
    // 고유번호 
    private int orderlistNum;

    // 주문번호 
    private int orderNumber;

    // 책번호 
    private int bookNum;

    // 구매수량 
    private int bookCount;
}
