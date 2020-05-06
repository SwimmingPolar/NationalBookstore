package com.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.service.book.AdminBookService;
import com.ryan.domain.book.EBookVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/book/*")
public class AdminBookController {
	
	@Setter(onMethod_ = {@Autowired})	//이벤트- 책 추천, 책 등록, 수정, 삭제
	private AdminBookService service;
	
	@RequestMapping("/adminpage")
	public String statusLike(Model model, @RequestParam("date") String date) {		
		
		model.addAttribute("lookup", service.statusLookup());		//조회수 
		model.addAttribute("like", service.statusLike());			//좋아요
		model.addAttribute("bestreader", service.bestReader(date));	//책 많이 읽은 사람
		
		
		return "관리자페이지";
	}	

	
	@RequestMapping(value = "/upload/uploadForm",method = RequestMethod.POST)
	public String insertBook(ArrayList<MultipartFile> files, EBookVO vo, HttpServletRequest request) throws IOException {
		for(MultipartFile file : files) {
			log.info("파일이름"+file.getOriginalFilename());
			log.info("파일크기"+file.getSize());
			log.info("컨텐트타임"+file.getContentType());
			
			String saveName = file.getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("\\")+"\\NationalBookstore\\src\\main\\webapp\\resources\\data";
			String imgpath = request.getSession().getServletContext().getRealPath("\\")+"\\NationalBookstore\\src\\main\\webapp\\resources\\thumbnail";
			
			if(file.getContentType().equals("jpg")) {
				//임시 디렉토리에 저장된 업로드 파일을 지정된 디렉토리로 복사
				//fileCopyUtils.copy(바이트배열, 파일객체)
				File target = new File(path,saveName);
				FileCopyUtils.copy(file.getBytes(), target);
				vo.setBookThumbnail(path+"/"+file.getOriginalFilename());
			}else {
				File target = new File(imgpath,saveName);
				FileCopyUtils.copy(file.getBytes(), target);
				vo.setBookPath(imgpath+"/"+saveName);
			}
		}		
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
