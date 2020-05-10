package com.admin.service.board;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.board.NoticeBoard;
import com.admin.domain.board.PageVO;
import com.admin.mapper.NoticeBoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private NoticeBoardMapper mapper;
	
	@Override
	public boolean noticeWrite(NoticeBoard notice) {
		return mapper.insertWrite(notice)>0?true:false;
	}
	
	@Override
	public boolean noticeDelete(NoticeBoard notice) {
		return mapper.delelteNotice(notice)>0?true:false;
	}
	
	@Override
	public boolean noticeUpdate(NoticeBoard notice) {
		return mapper.updateNotice(notice)>0?true:false;
	}


	@Override
	public int selectCount(String type) {
		return mapper.selectCount(type);
	}

	@Override
	public ArrayList<NoticeBoard> selectPageList(PageVO pagevo,String type) {
		RowBounds rb=new RowBounds(pagevo.getStartContent(),10);
		return mapper.selectPageList(type, rb);
	}
}
