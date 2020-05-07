package com.ryan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.service.member.FollowService;

import lombok.Setter;

@Controller
@RequestMapping("/follow/*")
public class FollowController {
	
	@Setter(onMethod_ = {@Autowired})
	private FollowService service;
	
	@RequestMapping("/request")
	public String requestFollow() {
		
		
		return null;
	}

}
