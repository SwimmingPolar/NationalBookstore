package com.ryan.domain.book;

import lombok.Data;

@Data
public class SecondCategoryVO {

	 // 고유번호 
    private int categoryNum;

    // 카테고리 
    private String bookCategory;

    // 이미지경로 
    private String categoryPath;

    // 최상위 카테고리 
    private int firstNum;
 
}
