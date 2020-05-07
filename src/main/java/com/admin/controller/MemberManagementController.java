package com.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/member/*")
@Log4j
public class MemberManagementController {
	
	//회원관리 시작해야함 메모.
	
	//여기다가 회원 정지 도 한번에 컨트롤러 작성.
	
	@InitBinder // 모든 컨트롤러 실행전에 실행됨
	public void initBinder(WebDataBinder binder) {
		log.info("initBinder 시작!");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	
	
}
