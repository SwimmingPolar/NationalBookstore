package com.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.NoticeBoardVO;
import com.admin.domain.board.PageVO;
import com.admin.service.board.NoticeBoardService;
import com.ryan.domain.member.MemberVO;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardcontroller {
	
	@Autowired
	private NoticeBoardService service;

	@RequestMapping("/writeForm")
	public String noticeWriteForm() {
		return "입력jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String noticeWrite(Model model,NoticeBoardVO notice,MultipartFile uploadFile,HttpServletRequest request,ArrayList<MultipartFile> files) {
		boolean flag=false;
		if(notice!=null) {
			flag = service.noticeWrite(notice);
			if(flag&&files.isEmpty()&&files.size()>0) {
				String path = request.getSession().getServletContext().getRealPath("\\")+"\\NationalBookstore\\src\\main\\webapp\\resources\\noticeFile";
				try {
					service.insertFiles(notice, files, path);
					model.addAttribute("message2", "파일입력성공");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else
				model.addAttribute("message2", "파일입력실패");
			
			if(flag)
				model.addAttribute("message", "공지사항 등록 성공");
			else
				model.addAttribute("message", "공지사항 등록 실패");
		}else
			model.addAttribute("message", "내용이 없습니다");
		return "redirect:/board/notice/page";
	}
	
	@RequestMapping("/delete")
	public String noticeDelete(NoticeBoardVO notice) {
		return service.noticeDelete(notice)?"삭제 실패시":"실패시 이동";
	}
	
	@RequestMapping("/updateForm")
	public String noticeUpdateForm() {
		return "수정jsp";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String noticeUpdate(NoticeBoardVO notice,MultipartFile uploadFile) {
		return service.noticeDelete(notice)?"업로드 성공시 이동":"실패시 이동";
	}
	
	//공지사항 페이지로 들어감
	@RequestMapping("/page")
	public String noticePage(Model model,@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="type", defaultValue="타입 종류?")String type) {
		
		PageVO pagevo=new PageVO(page,service.selectCount(type));
		
		//해당패이지 게시물 리스트 넘김
		model.addAttribute("pageList", service.selectPageList(pagevo, type));
		//페이지객체 저장해서 넘김
		model.addAttribute("pagevo", pagevo);
		
		return "notice page view";
	}
	
	@RequestMapping("/detail")
	//클릭한 문의사항관련 객체를 EnquiryBoardVO enquiry로 넘겨야 합니다
	public String enquirySelect(Model model,@RequestParam(value="noticeNo", defaultValue="1")int noticeNo,HttpServletRequest request) {
		NoticeBoardVO notice=service.selectNotice(noticeNo);
		if(notice!=null) {
			//선택한 문의사항 객체 
			model.addAttribute("noticeVO", notice);
			//선택한 문의사항 replyList
			model.addAttribute("fileList", "");
			return "선택한 문의사항 view";
		}else
			return "redirect:/board/notice/page";
			
	}
}
