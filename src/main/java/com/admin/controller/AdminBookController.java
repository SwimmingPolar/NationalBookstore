package com.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.service.AdminBookService;
import com.ryan.domain.book.EBookVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
public class AdminBookController {
	
	@Setter(onMethod_ = {@Autowired})	//이벤트- 책 추천, 책 등록, 수정, 삭제
	private AdminBookService service;
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@RequestMapping("/관리자페이지")
	public String statusLike(Model model, @RequestParam("date") String date) {		
		
		model.addAttribute("lookup", service.statusLookup());		//조회수 
		model.addAttribute("like", service.statusLike());			//좋아요
		model.addAttribute("bestreader", service.bestReader(date));	//책 많이 읽은 사람
		
		
		return "관리자페이지";
	}	

	
	@RequestMapping(value = "/upload/uploadForm",method = RequestMethod.POST)
	public String insertBook(MultipartFile[] file, EBookVO vo) throws IOException {
		log.info("파일이름"+file[0].getOriginalFilename());
		log.info("파일크기"+file[0].getSize());
		log.info("컨텐트타임"+file[0].getContentType());
		
		log.info("파일이름"+file[1].getOriginalFilename());
		log.info("파일크기"+file[1].getSize());
		log.info("컨텐트타임"+file[1].getContentType());
		
		String saveName = file[0].getOriginalFilename();
		
		File target = new File(uploadPath,saveName);
		File target2 = new File(uploadPath,file[1].getOriginalFilename());
		
		//임시 디렉토리에 저장된 업로드 파일을 지정된 디렉토리로 복사
		//fileCopyUtils.copy(바이트배열, 파일객체)
		FileCopyUtils.copy(file[0].getBytes(), target);
		FileCopyUtils.copy(file[1].getBytes(), target2);

		vo.setBookPath(uploadPath+"/"+saveName);
		vo.setBookThumbnail(uploadPath+"/"+file[1].getOriginalFilename());
		
		EBookVO vo1 = service.insertBook(vo);
		log.info("결과"+vo1.getBookNum()+","+vo1.getBookPath());
		return "";
	}
	
	
	@RequestMapping("/updatebook")
	public Boolean updateBook(EBookVO vo) {
		return service.updateBook(vo);
	}
	
	@RequestMapping("/deletebook")
	public Boolean deleteBook(@RequestParam("deletenum") int[] booknum) {
		return service.deleteBook(booknum);
	}
	
	
	
	
}
