package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardcontroller {
	
	
	//페이지처리
	//게시물생성/수정/삭제
	//게시물보기
	//파일첨부
	//댓글생성,수정,삭제
	@RequestMapping("/main")
	public void notice() {
		
	}
	
	//@RequestMapping("")
}
