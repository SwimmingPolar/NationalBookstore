package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.MyLibVO;
import com.ryan.domain.MyReadBookVO;
import com.ryan.service.MyBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booklist/*")
@Log4j
public class MyBookController {

	@Setter(onMethod_ = {@Autowired})
	private MyBookService service;
	
	@RequestMapping("/mylist")	//찜 책장
	public String myBookList(MyLibVO vo, Model model, HttpServletRequest request) {
		ArrayList<MyLibVO> list = service.readingBook(vo, request);
		model.addAttribute("mybooklist", list);				
		return "view";
	}
	
	
	@RequestMapping("/deleteList")
	public @ResponseBody ArrayList<MyLibVO> deleteList(MyLibVO vo, @RequestParam("booknumber") int booknumber, Model model) {
		ArrayList<MyLibVO> arraylist = service.deleteList(vo);
		return arraylist;
	}
	
	@RequestMapping("/readbook") 	//읽은 책 조회
	public String myReadBook(MyReadBookVO vo, Model model) {
		model.addAttribute("readbooklist", service.readBookList(vo));
		return "view";
	}
	
	//읽은 책 목록에서 삭제하기
	@RequestMapping("/deletereadbook")
	public @ResponseBody ArrayList<MyReadBookVO> deleteReadBook(MyReadBookVO vo) {
		return service.deleteReadBook(vo);
	}
	
}
