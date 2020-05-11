package com.admin.mapper;

import java.util.ArrayList;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.ReplyVO;

public interface EnquiryBoardMapper {
	//입력
	public int insertEq(EnquiryBoardVO eqboard);
		
	//삭제
	public int deleteEq(EnquiryBoardVO eqboard);
	
	//수정
	public int updateEq(EnquiryBoardVO eqboard);
	
	//문의사항을 관리자와 문의자가 상담요청(문의시작시/기본값/재상담)0, 응답완료(관리자)1, 상담완료(문의자)2 로 값수정함
	public int updateEqState(int boardNum,int boardState);
	
	//문의사항 리스트
	public ArrayList<EnquiryBoardVO> selectEqList(String memberEmail);
	
	//리플입력
	public int insertReply(EnquiryBoardVO eqboard);
		
	//리플삭제
	public int deleteReply(EnquiryBoardVO eqboard);
		
	//리플수정
	public int updateReply(EnquiryBoardVO eqboard);
	
	//해당게시물 리플 리스트
	public ArrayList<ReplyVO> selectReplyList(int boardNum);
}
