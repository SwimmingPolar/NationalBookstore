package com.admin.mapper;

import java.util.ArrayList;

import com.admin.domain.board.FileVO;

public interface FileBoardMapper {
	//파일 등록
	public int insertFile(FileVO file);
		
	//enquiry 파일 삭제
	public int deleteFile(int fileNum);
		
	//enquiry 해당게시물 모든 파일 삭제
	public int deleteAllFiles(int boardNum);
	
	//notice 파일 삭제
	public int deleteNoticeFile(int fileNum);
	
	//notice 해당게시물 모든파일 삭제
	public int deleteAllNoticeFiles(int noticeNo);
	
	//enquiryfile 리스트 반환
	public ArrayList<FileVO> selectEqFileList();
	
	//noticefile 리스트 반환
	public ArrayList<FileVO> selectNoticeFileList();
}
