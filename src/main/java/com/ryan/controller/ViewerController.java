package com.ryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewer/*")
public class ViewerController {

	@RequestMapping(value="/main")
	public String ViewerMain() {
		return "viewer";
	}
}
