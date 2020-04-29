package com.ryan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.service.book.MyBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booklist/*")
@Log4j
public class MyBookController {

	@Setter(onMethod_ = {@Autowired})
	private MyBookService service;
	
	@RequestMapping("/myLibList")	//찜 책장
	public String myBookList(Model model, MyLibVO vo) {
		List<MyLibVO> list = service.libBook(vo);
		model.addAttribute("libbooklist", list);
		return "view";
	}
	
	
	@RequestMapping("/deleteLibList")
	public @ResponseBody List<MyLibVO> deleteList(MyLibVO vo) {
		return service.deleteLibBook(vo);
	}
	
	@RequestMapping("/readbooklist") 	//읽은 책 조회
	public String myReadBook(Model model, MyReadBookVO vo) {
		model.addAttribute("readbooklist", service.readBook(vo));
		return "view";
	}
	
	//읽은 책 목록에서 삭제하기
	@RequestMapping("/deletereadbook")
	public @ResponseBody List<MyReadBookVO> deleteReadBook(MyReadBookVO vo) {
		return service.deleteReadBook(vo);
	}
		
}
