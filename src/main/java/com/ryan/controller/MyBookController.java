package com.ryan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.BookAlarmVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.service.book.MyBookAlarmService;
import com.ryan.service.book.MyBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booklist/*")
@Log4j
public class MyBookController {

	@Setter(onMethod_ = {@Autowired})
	private MyBookService service;
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookAlarmService aservice;
	
	@RequestMapping("/myLibList")	//찜 책장
	public String myBookList(Model model, HttpServletRequest request) {
		List<MyLibVO> list = service.libBook(request);
		model.addAttribute("libbooklist", list);
		return "view";
	}
	
	
	@RequestMapping("/deleteLibList")
	public @ResponseBody List<MyLibVO> deleteList(MyLibVO vo) {
		return service.deleteLibBook(vo);
	}
	
	@RequestMapping("/readbooklist") 	//읽은 책 조회
	public String myReadBook(Model model, HttpServletRequest request) {
		model.addAttribute("readbooklist", service.readBook(request));
		return "view";
	}
	
	//읽은 책 목록에서 삭제하기
	@RequestMapping("/deletereadbook")
	public @ResponseBody List<MyReadBookVO> deleteReadBook(MyReadBookVO vo) {
		return service.deleteReadBook(vo);
	}
	
	//알람 받을 책 등록
	@RequestMapping("/alarm")
	public @ResponseBody Boolean requestAlarm(BookAlarmVO vo, HttpSession session) {
		return aservice.requestAlarm(vo, session);
	}
	
	//출판 되어 알람시켜줘야 할 책 
	public ArrayList<BookAlarmVO> showAlarm(HttpSession session){
		return aservice.showAlarm(session);
	}

	
	//메인에서 출판일자별로 신작예정도서 출력
	
	
	
		
}
