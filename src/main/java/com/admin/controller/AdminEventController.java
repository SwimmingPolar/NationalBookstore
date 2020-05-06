package com.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.domain.AdminBestListVO;
import com.admin.service.AdminEventService;

import lombok.Setter;

@Controller
@RequestMapping("admin/event/*")
public class AdminEventController {

	@Setter(onMethod_ = {@Autowired})
	private AdminEventService service;
	
	@RequestMapping("/pushbook")				//추천책 등록
	public Boolean pushBook(ArrayList<AdminBestListVO> booknum) {
		return service.pushBook(booknum);
	}
	
	@RequestMapping("/deletePushBook")			//추천책 삭제
	public Boolean deleteBook(int[] deletenum) {
		return service.deleteBook(deletenum);
	}
}
