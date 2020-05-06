package com.admin.domain.book;

import lombok.Data;

@Data
public class AdminBestListVO {

    // 고유번호 
    private int bestlistNum;

    // 카테고리번호 
    private int categoryNum;

    // 책번호 
    private int bookNum;
}
