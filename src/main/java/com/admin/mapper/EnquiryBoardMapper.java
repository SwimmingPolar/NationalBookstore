package com.admin.mapper;

import java.util.ArrayList;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.FileVO;
import com.admin.domain.board.ReplyVO;

public interface EnquiryBoardMapper {
	//입력
	public int insertEq(EnquiryBoardVO enquiry);
		
	//삭제
	public int deleteEq(EnquiryBoardVO enquiry);
	
	//수정
	public int updateEq(EnquiryBoardVO enquiry);
	
	//문의사항을 관리자와 문의자가 상담요청(문의시작시/기본값/재상담)0, 응답완료(관리자)1, 상담완료(문의자)2 로 값수정함
	public int updateEqState(int boardNum,int boardState);
	
	//문의사항 리스트
	public ArrayList<EnquiryBoardVO> selectEqList(String memberEmail);
	
	//해당문의사항이 존제하는지 확인
	public int numChk(int boardNum);
	
	//리플입력
	public int insertReply(ReplyVO reply);
		
	//리플삭제
	public int deleteReply(ReplyVO reply);
	
	//해당 문의사항의 모든 리플삭제
	public int deleteAllReply(EnquiryBoardVO enquiry);
		
	//리플수정
	public int updateReply(ReplyVO reply);
	
	public EnquiryBoardVO selectEq(int boardNum);
	
	//해당게시물 리플 리스트
	public ArrayList<ReplyVO> selectReplyList(int boardNum);
	
	
	public ArrayList<EnquiryBoardVO> selectLastSeqNum(EnquiryBoardVO enquiry);
	
	//파일 등록
	public int insertFile(FileVO file);
	
	//파일 삭제
	public int deleteFile(int fileNum);
	
	//해당게시물 모든 파일 삭제
	public int deleteAllFiles(int boardNum);
	
	
}
