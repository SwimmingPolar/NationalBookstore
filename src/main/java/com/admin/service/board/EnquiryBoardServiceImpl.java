package com.admin.service.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.FileVO;
import com.admin.domain.board.ReplyVO;
import com.admin.mapper.EnquiryBoardMapper;

@Service
public class EnquiryBoardServiceImpl implements EnquiryBoardService{
	
	@Autowired
	private EnquiryBoardMapper mapper;

	@Override
	public boolean eqWrite(EnquiryBoardVO enquiry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eqDelete(EnquiryBoardVO enquiry) {
		if(enquiry.getBoardNum()>0||mapper.numChk(enquiry.getBoardNum())>0) {
			mapper.deleteAllReply(enquiry);
			mapper.deleteEq(enquiry);
			return true;
		}else
			return false;
	}

	@Override
	public boolean eqUpdate(EnquiryBoardVO enquiry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<EnquiryBoardVO> selectList(String memberEmail) {
		return mapper.selectEqList(memberEmail);
	}

	@Override
	public EnquiryBoardVO selectEq(int boardNum) {
		if(mapper.numChk(boardNum)>0)
			return mapper.selectEq(boardNum);
		else
			return null;
	}

	@Override
	public ArrayList<ReplyVO> selectReplyList(int boardNum) {
		return mapper.selectReplyList(boardNum);
	}

	@Override
	public ArrayList<FileVO> selectEqFileList(int boardNum) {
		return null;
	}

	@Override
	public boolean replyWrite(ReplyVO reply) {
		return mapper.insertReply(reply)>0?true:false;
	}

	@Override
	public boolean replyDelete(ReplyVO reply) {
		return mapper.deleteReply(reply)>0?true: false;
	}

	@Override
	public boolean replyUpdate(ReplyVO reply) {
		return mapper.updateReply(reply)>0?true: false;
	}

}
