package com.admin.service.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

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
		return mapper.insertEq(enquiry)>0?true:false;
	}

	@Override
	public boolean eqDelete(EnquiryBoardVO enquiry) {
		if(enquiry.getBoardNum()>0||mapper.numChk(enquiry.getBoardNum())>0) {
			mapper.deleteAllFiles(enquiry.getBoardNum());
			mapper.deleteAllReply(enquiry);
			return mapper.deleteEq(enquiry)>0?true:false;
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

	@Override
	public boolean insertFiles(EnquiryBoardVO enquiry,ArrayList<MultipartFile> files,String path) throws IOException {
		ArrayList<EnquiryBoardVO> tmp=mapper.selectLastSeqNum(enquiry);
		boolean flag=false;
		for(MultipartFile file : files)  {
			FileVO vo=new FileVO();
			vo.setBoardNum(tmp.get(tmp.size()).getBoardNum());
			vo.setOriginFileName(file.getOriginalFilename());
			vo.setStoredFileName(UUID.randomUUID().toString()+"_"+file.getOriginalFilename());
			File target=new File(path,vo.getStoredFileName());
			FileCopyUtils.copy(file.getBytes(), target);
			flag=mapper.insertFile(vo)>0?true:false;
		}
		return flag;
	}

	@Override
	public boolean deleteFile(int fileNum) {
		return false;
	}

}
