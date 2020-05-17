package com.admin.service.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.FileVO;
import com.admin.domain.board.NoticeBoardVO;
import com.admin.domain.board.PageVO;
import com.admin.mapper.FileBoardMapper;
import com.admin.mapper.NoticeBoardMapper;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	
	@Autowired
	private NoticeBoardMapper mapper;
	
	@Autowired
	private FileBoardMapper fileMapper;
	
	@Override
	public boolean noticeWrite(NoticeBoardVO notice) {
		return mapper.insertNotice(notice)>0?true:false;
	}
	
	@Override
	public boolean noticeDelete(NoticeBoardVO notice,HttpServletRequest request) {
		String path=request.getSession().getServletContext().getRealPath("\\")+"\\NationalBookstore\\src\\main\\webapp\\resources\\noticeFile";
		if(mapper.numChk(notice.getNoticeNo())>0) {
			ArrayList<FileVO> tmp=fileMapper.selectNoticeFileList(notice.getNoticeNo());
			if(tmp!=null&&tmp.size()>0&&fileMapper.deleteAllNoticeFiles(notice.getNoticeNo())>0) {
				for(FileVO file : tmp) {
					new File(path+"\\"+file.getStoredFileName()).delete();
				}
			}
			return mapper.deleteNotice(notice)>0?true:false;
		}else
			return false;
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
	public ArrayList<FileVO> selectNoticeFileList(int noticeNo) {
		return null;
	}

	@Override
	public boolean insertFiles(NoticeBoardVO notice, ArrayList<MultipartFile> files,HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("\\")+"\\NationalBookstore\\src\\main\\webapp\\resources\\noticeFile";
		boolean flag=false;
		for(MultipartFile file : files)  {
			FileVO vo=new FileVO();
			vo.setNoticeNo(notice.getNoticeNo());
			vo.setOriginFileName(file.getOriginalFilename());
			vo.setStoredFileName(UUID.randomUUID().toString()+"_"+file.getOriginalFilename());
			File target=new File(path,vo.getStoredFileName());
			FileCopyUtils.copy(file.getBytes(), target);
			flag=fileMapper.insertFile(vo)>0?true:false;
		}
		return flag;
	}

	@Override
	public boolean deleteFile(int fileNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoticeBoardVO selectNotice(int noticeNo) {
		if(mapper.numChk(noticeNo)>0)
			return mapper.selectNotice(noticeNo);
		else
			return null;
	}

	@Override
	public boolean updateFileList(NoticeBoardVO notice, ArrayList<MultipartFile> files,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("\\")+"\\NationalBookstore\\src\\main\\webapp\\resources\\noticeFile";
		boolean flag=true;
		if(notice!=null) {
			ArrayList<FileVO> tmp=fileMapper.selectNoticeFileList(notice.getNoticeNo());
			if(tmp!=null) {
				for(FileVO file : tmp) {
					fileMapper.deleteFile(file.getFileNum());
					new File(path+"\\"+file.getStoredFileName()).delete();
				}
			}
			for(MultipartFile file : files) {
				FileVO vo=new FileVO();
				vo.setNoticeNo(notice.getNoticeNo());
				vo.setOriginFileName(file.getOriginalFilename());
				vo.setStoredFileName(UUID.randomUUID().toString()+"_"+file.getOriginalFilename());
				File target=new File(path,vo.getStoredFileName());
				try {
					FileCopyUtils.copy(file.getBytes(), target);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(fileMapper.insertFile(vo)<1)
					flag=false;
				
			}
		}
		
		return flag;
	}
}
