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
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.service.book.MyBookAlarmService;
import com.ryan.service.book.MyBookService;
import com.ryan.service.member.FollowService;

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
	
	@Setter(onMethod_ = {@Autowired})
	private FollowService fservice;
	
	@RequestMapping("/myLibList")	//찜 책장
	public String myBookList(Model model, HttpSession session) {
		ArrayList<EBookVO> list = service.libBook(session);
		model.addAttribute("libbooklist", list);
		model.addAttribute("libcount",service.countLibBook(session));		//찜 책장 수량
		return "myLibrary";
	}
	
	
	@RequestMapping("/deleteLibList")
	public @ResponseBody List<EBookVO> deleteList(MyLibVO vo) {
		return service.deleteLibBook(vo);
	}
	
	@RequestMapping("/readbooklist") 	//읽은 책 조회
	public String myReadBook(Model model, HttpSession session) {
		model.addAttribute("readbooklist", service.readBook(session));	//읽은책 리스트
		model.addAttribute("readbookcount", service.countReadBook(session)); 		//읽은책 수량
		return "myLibrary";
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
	
	//나를 팔로우한 사람의 수
	public Model myfolower(HttpSession session, Model model) {
		return model.addAttribute("myFollower",fservice.countFollow(session));
	}
	
		
}
