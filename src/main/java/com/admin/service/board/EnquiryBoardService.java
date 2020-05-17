package com.admin.service.board;

import java.io.IOException;
import java.util.ArrayList;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;

>>>>>>> 0d7cf6607dc5a1404e6b3f0c603312aeec65d05c
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.FileVO;
import com.admin.domain.board.ReplyVO;

public interface EnquiryBoardService {
	//문의사항 작성
	public boolean eqWrite(EnquiryBoardVO enquiry);
	
	public boolean eqDelete(EnquiryBoardVO enquiry);
	
	public boolean eqUpdate(EnquiryBoardVO enquiry,ArrayList<MultipartFile> files,HttpServletRequest request);
	
	//사용자 문의사항 리스트 반환
	public ArrayList<EnquiryBoardVO> selectList(String memberEmail);
	
	//선택한 문의사항 정보반환,enquiryvo,replylist,filelist
	public EnquiryBoardVO selectEq(int boardNum);
	
	//선택 문의사항 리플리스트 반환
	public ArrayList<ReplyVO> selectReplyList(int boardNum);
	
	//선택 문의사항 파일리스트 반환
	public ArrayList<FileVO> selectEqFileList(int boardNum);
	
	//파일등록
	public boolean insertFiles(EnquiryBoardVO enquiry,ArrayList<MultipartFile> files,String path) throws IOException;
	
	//파일삭제
	public boolean deleteFile(int fileNum);
	
	//리블 작성
	public boolean replyWrite(ReplyVO reply);
	
	public boolean replyDelete(ReplyVO reply);
	
	public boolean replyUpdate(ReplyVO reply);
}
