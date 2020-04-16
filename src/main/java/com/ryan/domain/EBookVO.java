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
    private String category;

    // 작가 
    private String writer;

    // 출판일자 
    private Date bookPbDate;

    // 출판사 
    private String publisher;

    // 썸네일 
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
	
	
}
