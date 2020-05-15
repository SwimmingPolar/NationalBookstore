package com.admin.mapper;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.admin.domain.board.NoticeBoardVO;

public interface NoticeBoardMapper {
	//입력
	public int insertNotice(NoticeBoardVO notice);
	
	//삭제
	public int deleteNotice(NoticeBoardVO notice);
	
	//수정
	public int updateNotice(NoticeBoardVO notice);
	
	//공지사항 클릭시 해당 공지사항객체반환
	public NoticeBoardVO selectNotice(int noticeNo);
	
	//페이지 작업을 위한 전체 게시물수 받아오기
	public int selectNoticeCount(String type);
	
	//요청페이지 게시물 리스트
	public ArrayList<NoticeBoardVO> selectNoticePageList(String type,RowBounds rb);
	
	//해당공지사항이 존제하는지 확인
	public int numChk(int noticeNo);
	
	

}
