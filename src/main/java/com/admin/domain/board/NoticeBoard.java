package com.admin.domain.board;

import lombok.Data;

@Data
public class NoticeBoard {
	// board_num 
    private int noticeNo;
    
    //category
    private String noticeCategory;

    // 제목 
    private String noticeTitle;

    // 내용 
    private String noticeContent;

    // 회원아이디 
    private String noticeWriter;
    
    // 작성날자 
    private String boardDate;
}
