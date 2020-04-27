package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EBookVO {
    // 책 고유번호 
    private int bookNum;

    // 책 이름 
    private String bookTitle;

    // 나라 분류 
    private int bookCountry;

    // 카테고리 
    private String bookCategory;
    
    private int categoryNum;

    // 작가 
    private String bookWriter;

    // 출판일자 
    private Date bookPbDate;

    // 출판사 
    private String bookPublisher;

    // 섬네일 
    private String bookThumbnail;

    // 책 가격 
    private int bookPrice;

    // 할인 
    private int bookDiscount;

    // 경로 
    private String bookPath;

    // 실물여부 
    private int bookExistence;

    // 조회수 
    private int bookLookup;
    
    //책 소개 추가
    
    //목차 추가
	
}
