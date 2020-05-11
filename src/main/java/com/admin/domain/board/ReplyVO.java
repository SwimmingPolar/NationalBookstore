package com.admin.domain.board;

import lombok.Data;

@Data
public class ReplyVO {
    // reply_num 
    private int replyNum;

    // board_num 
    private int boardNum;

    // 작성자 
    private String writer;

    // 내용 
    private String replyContent;

}
