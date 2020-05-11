package com.admin.service.board;

import java.util.ArrayList;

import com.admin.domain.board.NoticeBoard;
import com.admin.domain.board.PageVO;

public interface BoardService {
	
	//notice 게시물 작성
	public boolean noticeWrite(NoticeBoard notice);
	
	public boolean noticeDelete(NoticeBoard notice);
	
	public boolean noticeUpdate(NoticeBoard notice);
	
	//notice 총게시물수확인
	public int selectCount(String type);
	
	//notice 요청페이지 게시물 리스트 반환
	public ArrayList<NoticeBoard> selectPageList(PageVO pagevo,String type);

}
