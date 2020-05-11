package com.admin.service.board;

import java.util.ArrayList;

import com.admin.domain.board.FileVO;
import com.admin.domain.board.NoticeBoardVO;
import com.admin.domain.board.PageVO;

public interface NoticeBoardService {
	
	//notice 게시물 작성
	public boolean noticeWrite(NoticeBoardVO notice);
	
	public boolean noticeDelete(NoticeBoardVO notice);
	
	public boolean noticeUpdate(NoticeBoardVO notice);
	
	//notice 총게시물수확인
	public int selectCount(String type);
	
	//notice 요청페이지 게시물 리스트 반환
	public ArrayList<NoticeBoardVO> selectPageList(PageVO pagevo,String type);
	
	public ArrayList<FileVO> selectNoticeFileList(int boardNum);

}
