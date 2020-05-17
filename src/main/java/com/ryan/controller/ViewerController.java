package com.ryan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.service.book.ViewerService;

@Controller
public class ViewerController {
	@Autowired
	ViewerService sv;
	
	@RequestMapping(value="/viewer")
	public String ViewerMain(String bookNum, Model model) {
		return "viewer2";
	}
}
