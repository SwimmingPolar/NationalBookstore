package com.ryan.domain;

import lombok.Data;

@Data
public class HashtagVO {
	   // 고유번호 
    private int hashNum;

    // 책번호 
    private int bookNum;

    // 태그 
    private String hashTag;
}
