package com.ryan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.domain.ReviewVO;
import com.ryan.service.main.ReviewServiceImpl;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl service;
	
	@RequestMapping("/write")
	public void insertReview(ReviewVO review) {
		
	}
	
	@RequestMapping("/delete")
	public void deleteReview(ReviewVO review) {
		
	}
	
	@RequestMapping("/update")
	public void updateReview(ReviewVO review) {
		
	}
}
