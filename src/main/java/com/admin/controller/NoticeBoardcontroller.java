package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.NoticeBoardVO;
import com.admin.domain.board.PageVO;
import com.admin.service.board.FileService;
import com.admin.service.board.NoticeBoardService;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardcontroller {
	
	@Autowired
	private NoticeBoardService service;
	
	@Autowired
	private FileService fileS;

	@RequestMapping("/writeForm")
	public String noticeWriteForm() {
		return "입력jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String noticeWrite(NoticeBoardVO notice,MultipartFile uploadFile) {
		boolean flag = service.noticeWrite(notice);
		
		if(flag) {
			
				
		}
		
		return "";
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
	
	@RequestMapping("/page")
	public String noticePage(Model model,@RequestParam(value="page", defaultValue="1")int page,String type) {
		
		PageVO pagevo=new PageVO(page,service.selectCount(type));
		
		model.addAttribute("pageList", service.selectPageList(pagevo, type));
		model.addAttribute("pagevo", pagevo);
		
		return "";
	}
}
