package com.ryan.domain;

import lombok.Data;

@Data
public class BookLikeVO {
	  // 좋아요 
    private int likeNum;

    // 회원아이디 
    private String memberId;

    // 책 번호 
    private int bookNum;
}
