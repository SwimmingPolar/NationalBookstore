package com.admin.domain.board;

import java.util.Date;

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
    private Date boardRegdate;
    
    // 기본값 0, 0은 문의사항 등록,재등록  1은 관리자 답변완료 2는 문의자가 문의종료시
    private int boardState;
}
