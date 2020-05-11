package com.admin.service.board;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.board.FileVO;
import com.admin.domain.board.NoticeBoardVO;
import com.admin.domain.board.PageVO;
import com.admin.mapper.NoticeBoardMapper;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	
	@Autowired
	private NoticeBoardMapper mapper;
	
	@Override
	public boolean noticeWrite(NoticeBoardVO notice) {
		return mapper.insertNotice(notice)>0?true:false;
	}
	
	@Override
	public boolean noticeDelete(NoticeBoardVO notice) {
		return mapper.deleteNotice(notice)>0?true:false;
	}
	
	@Override
	public boolean noticeUpdate(NoticeBoardVO notice) {
		return mapper.updateNotice(notice)>0?true:false;
	}


	@Override
	public int selectCount(String type) {
		return mapper.selectNoticeCount(type);
	}

	@Override
	public ArrayList<NoticeBoardVO> selectPageList(PageVO pagevo,String type) {
		RowBounds rb=new RowBounds(pagevo.getStartContent(),10);
		return mapper.selectNoticePageList(type, rb);
	}

	@Override
	public ArrayList<FileVO> selectNoticeFileList(int boardNum) {
		// TODO Auto-generated method stub
		return null;
	}
}
