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
	public String noticeWrite(Model model,NoticeBoardVO notice,HttpServletRequest request,ArrayList<MultipartFile> files) {
		boolean flag=false;
		if(notice!=null) {
			flag = service.noticeWrite(notice);
			if(flag&&!files.isEmpty()&&files.size()>0) {
				try {
					service.insertFiles(notice, files, request);
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
	public String noticeDelete(Model model,NoticeBoardVO notice,HttpServletRequest request) {
		if(notice!=null) {
			if(service.noticeDelete(notice,request))
				model.addAttribute("message", "문의사항 삭제 성공");
			else
				model.addAttribute("message", "문의사항 삭제 실패");
			return "redirect:/board/notice/page";
		}else {
			model.addAttribute("message", "선택된 내용이 없습니다.");
			return "redirect:/board/notice/page";
		}
	}
	
	@RequestMapping("/updateForm")
	public String noticeUpdateForm(Model model,@RequestParam(value="noticeNo", defaultValue="1")int noticeNo) {
		NoticeBoardVO notice=service.selectNotice(noticeNo);
		if(notice!=null) {
			//선택한 문의사항 객체 
			model.addAttribute("noticeVO", notice);
			//선택한 문의사항 replyList
			model.addAttribute("fileList", service.selectNoticeFileList(noticeNo));
			return "수정jsp";
		}else
			return "redirect:/board/notice/page";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String noticeUpdate(Model model,NoticeBoardVO notice,ArrayList<MultipartFile> files,HttpServletRequest request) {
		if(notice!=null) {
			service.noticeUpdate(notice);
			service.updateFileList(notice, files,request);
		}
		
		if(service.noticeUpdate(notice))
			model.addAttribute("message", "문의사항 업데이트 성공");
		else
			model.addAttribute("message", "문의사항 업데이트 실패");
		return "redirect:/board/notice/page";

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
			model.addAttribute("fileList", service.selectNoticeFileList(noticeNo));
			return "선택한 문의사항 view";
		}else
			return "redirect:/board/notice/page";
			
	}
}
