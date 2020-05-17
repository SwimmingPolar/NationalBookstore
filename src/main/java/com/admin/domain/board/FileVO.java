package com.admin.domain.board;

import lombok.Data;

@Data
public class FileVO {
    // file_num 
    private int fileNum;

    // board_num 
    private int boardNum;

    // 원본파일이름 
    private String originFileName;

    // 저장파일이름 
    private String storedFileName;
    
    //notice_no
    private int noticeNo;

}
