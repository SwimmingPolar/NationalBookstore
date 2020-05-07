package com.admin.domain.board;

import lombok.Data;

@Data
public class replyVO {
    // reply_num 
    private int replyNum;

    // board_num 
    private int boardNum;

    // 작성자 
    private String replyer;

    // 내용 
    private String replyContent;

}
