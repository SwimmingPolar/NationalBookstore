package com.admin.service.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.FileVO;
import com.admin.domain.board.NoticeBoardVO;
import com.admin.domain.board.PageVO;

public interface NoticeBoardService {
	
	//notice 게시물 작성
	public boolean noticeWrite(NoticeBoardVO notice);
	
	public boolean noticeDelete(NoticeBoardVO notice,HttpServletRequest request);
	
	public boolean noticeUpdate(NoticeBoardVO notice);
	
	//notice 총게시물수확인
	public int selectCount(String type);
	
	//notice 요청페이지 게시물 리스트 반환
	public ArrayList<NoticeBoardVO> selectPageList(PageVO pagevo,String type);
	
	public ArrayList<FileVO> selectNoticeFileList(int noticeNo);
	
	//파일등록
	public boolean insertFiles(NoticeBoardVO notice,ArrayList<MultipartFile> files,HttpServletRequest request) throws IOException;
		
	//파일삭제
	public boolean deleteFile(int fileNum);
	
	//공지사항 클릭시 해당 공지사항객체반환
	public NoticeBoardVO selectNotice(int noticeNo);
	
	public boolean updateFileList(NoticeBoardVO notice,ArrayList<MultipartFile> files,HttpServletRequest request);

}
