package com.admin.domain.board;

import lombok.Data;

@Data
public class enquiryBoardVO {
	// board_num 
    private int boardNum;

    // 회원아이디 
    private String memberEmail;

    // 제목 
    private String boardTitle;

    // 내용 
    private String boardContent;

    // 작성날자 
    private String boardRegdate;

}
