package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.domain.book.AdminBestListVO;
import com.admin.service.event.AdminEventService;

import lombok.Setter;

@Controller
@RequestMapping("admin/event/*")
public class AdminEventController {

	@Setter(onMethod_ = {@Autowired})
	private AdminEventService service;
	
	@RequestMapping("/pushbook")				//추천책 등록
	public Boolean pushBook(AdminBestListVO booknum) {
		return service.pushBook(booknum);
	}
	
	@RequestMapping("/deletePushBook")			//추천책 삭제
	public Boolean deleteBook(int[] deletenum, Model model) {
		boolean flag = service.deleteBook(deletenum);
		
		if(!flag) {
			return false;
		}else {
			return true;
		}
		
	}
}
