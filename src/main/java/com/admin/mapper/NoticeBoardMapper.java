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
	
	//페이지 작업을 위한 전체 게시물수 받아오기
	public int selectNoticeCount(String type);
	
	//요청페이지 게시물 리스트
	public ArrayList<NoticeBoardVO> selectNoticePageList(String type,RowBounds rb);

}
