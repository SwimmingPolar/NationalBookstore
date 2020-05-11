package com.admin.mapper;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.admin.domain.board.NoticeBoard;

public interface NoticeBoardMapper {
	public int insertWrite(NoticeBoard notice);
	
	public int delelteNotice(NoticeBoard notice);
	
	public int updateNotice(NoticeBoard notice);
	
	public int selectCount(String type);
	
	public ArrayList<NoticeBoard> selectPageList(String type,RowBounds rb);

}
