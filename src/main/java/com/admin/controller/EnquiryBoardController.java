package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/enquiry/*")
public class EnquiryBoardController {
	
	@RequestMapping("/writeForm")
	public String enquiryWriteForm() {
		return "입력jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String enquiryWrite() {
		
		return "";
	}
	
	@RequestMapping("/delete")
	public String enquiryDelete() {
		return "";
	}
	
	@RequestMapping("/updateForm")
	public String enquiryUpdateForm() {
		return "입력jsp";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String enquiryUpdate() {
		return "";
	}
	
	@RequestMapping("/showList")
	public String enquiryList() {
		return "";
	}
	
	@RequestMapping("/select")
	public String enquirySelect() {
		return "";
	}
	
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	public String replyWrite() {
		return "";
	}
	
	@RequestMapping("/replyDelete")
	public String replyDelete() {
		return "";
	}
	
	@RequestMapping(value="/replyUpdate", method=RequestMethod.POST)
	public String replyUpdate() {
		return "";
	}
}
