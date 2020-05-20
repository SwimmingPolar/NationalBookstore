package com.ryan.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/error/*")
@Log4j
public class ExceptionController {
	
	private final String path = "Error/";
	
	@GetMapping("404")
	public String handle404() {
		log.info("404에러 실행");
		return  path + "404";
	}
	
	@GetMapping("/403")
	public String handle403() {
		return path +"403";
	}
	
	@GetMapping("/400")
	public String handle400() {
		return path + "400";
	}
	
	@GetMapping("/401")
	public String handle401() {
		return path + "401";
	}
	
	@GetMapping("/500")
	public String handle500() {
		return path + "500";
	}
	
	
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public String handle400() {
//		
//	}
}
