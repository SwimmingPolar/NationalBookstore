package com.ryan.domain.book;
import java.util.Date;

//import javax.validation.constraints.Future;
//import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewVO {
	  // review_Num 
    private int reviewNum;

    // 책번호 
    //@NotNull(message="책번호 항목이 비었습니다")
    private int bookNum;

    // 회원아이디 
    //@NotNull(message="아이디 항목이 비었습니다")
    private String memberEmail;

    // 제목 
    //@NotNull(message="제목이 비었습니다")
    private String reviewTitle;

    // 내용 
    //@NotNull(message="내용이 비었습니다")
    private String reviewContent;

    // 작성날짜 
    //@Future(message="날짜 형식이 잘못되었습니다")
    private Date reviewRegdate;
    
    private String bookTitle;
}
