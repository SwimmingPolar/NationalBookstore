package com.admin.service.board;

import java.util.ArrayList;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.FileVO;
import com.admin.domain.board.ReplyVO;

public interface EnquiryBoardService {
	public boolean write();
	
	public boolean delete();
	
	public boolean update();
	
	public ArrayList<EnquiryBoardVO> selectList();
	
	public ArrayList<ReplyVO> selectReplyList(int boardNum);
	
	public ArrayList<FileVO> selectEqFileList(int boardNum);
}
