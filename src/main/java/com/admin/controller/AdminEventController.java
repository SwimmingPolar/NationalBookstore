package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.domain.AdminBestListVO;
import com.admin.service.AdminEventService;

import lombok.Setter;

@Controller
@RequestMapping("/event/*")
public class AdminEventController {

	@Setter(onMethod_ = {@Autowired})
	private AdminEventService service;
	
	@RequestMapping("/pushbook")
	public Boolean pushBook(AdminBestListVO vo) {
		return service.pushBook(vo);
	}
}
