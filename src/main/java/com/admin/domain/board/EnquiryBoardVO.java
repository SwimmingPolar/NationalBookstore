package com.admin.domain.board;

import lombok.Data;

@Data
public class EnquiryBoardVO {
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
    
    //문의사항 기본값,재질문시 =0, 관리자 답변완료=1, 문의자가 상담완료해주면=2
    private int boardState;

}
