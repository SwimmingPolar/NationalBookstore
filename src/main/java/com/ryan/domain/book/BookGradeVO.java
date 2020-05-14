package com.ryan.domain.book;

import lombok.Data;

@Data
public class BookGradeVO {
	  // 고유번호 
    private int gradeNum;

    // 회원 아이디 
    private String memberEmail;

    // 책 번호 
    private int bookNum;

    // 평점 
    private double gradeScore;
    
    private String bookTitle;
}
