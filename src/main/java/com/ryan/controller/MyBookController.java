package com.ryan.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.MyLibVO;
import com.ryan.service.MyBookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booklist/*")
@Log4j
public class MyBookController {

	@Setter(onMethod_ = {@Autowired})
	private MyBookService service;
	
	@RequestMapping("/list")
	public String myBookList(MyLibVO vo, Model model) {
		ArrayList<MyLibVO> list = service.readingBook(vo);
		model.addAttribute("mybooklist", list);				
		return "view";
	}
	
	
	@RequestMapping("/deleteList")
	public @ResponseBody ArrayList<MyLibVO> deleteList(MyLibVO vo, @RequestParam("booknumber") int booknumber, Model model) {
		ArrayList<MyLibVO> arraylist = service.deleteList(vo);
		return arraylist;
	}
	
	
}
