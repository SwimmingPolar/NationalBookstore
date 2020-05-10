package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.NoticeBoard;
import com.admin.domain.board.PageVO;
import com.admin.service.board.BoardService;
import com.admin.service.board.FileService;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardcontroller {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private FileService fileS;

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String noticeWrite(NoticeBoard notice,MultipartFile uploadFile) {
		boolean flag = service.noticeWrite(notice);
		
		if(flag) {
			
				
		}
		
		return "";
	}
	
	@RequestMapping("/delete")
	public String noticeDelete(NoticeBoard notice) {
		return service.noticeDelete(notice)?"":"";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String noticeUpdate(NoticeBoard notice,MultipartFile uploadFile) {
		return service.noticeDelete(notice)?"":"";
	}
	
	@RequestMapping("/page")
	public String noticePage(Model model,@RequestParam(value="page", defaultValue="1")int page,String type) {
		
		PageVO pagevo=new PageVO(page,service.selectCount(type));
		
		model.addAttribute("pageList", service.selectPageList(pagevo, type));
		model.addAttribute("pagevo", pagevo);
		
		return "";
	}
	
	//@RequestMapping("")
}
