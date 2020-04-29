package com.ryan.controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryan.domain.book.EBookVO;
import com.ryan.service.main.SearchServiceImpl;

//순서대로 e북 리스트, 현물책 리스트, 요청페이지에 띄울 리스트 정보가 들어있다
@Controller
@SessionAttributes({"result","ebooklist","booklist","pageList"})
@RequestMapping("/search/*")
public class SearchController {
	
	@Autowired
	private SearchServiceImpl service;
	
	//검색후 e북과 현물북 리스트를 세션에 저장한다
	@RequestMapping("/search")
	public String searchBook(Model model,String type,@RequestParam(value = "keyword", required = false, defaultValue=" ") String keyword) {
		System.out.println("검색 실행(param1:"+type+",param2:"+keyword+")");
		HashMap<String, List<EBookVO>> result = new HashMap<String, List<EBookVO>>();
		
		String [] tmp=keyword.split("\\s+");
		System.out.println("실행");

		ArrayList<EBookVO> ebList=new ArrayList<EBookVO>(); 
		ArrayList<EBookVO> bList=new ArrayList<EBookVO>(); 
		ebList.addAll(service.ebookList(type, tmp));
		bList.addAll(service.bookList(type, tmp));

		result.put("ebook", service.ebookList(type, tmp));
		result.put("paper", service.bookList(type, tmp));
		
		model.addAttribute("result", result);
		model.addAttribute("ebooklist",ebList);
		model.addAttribute("booklist",bList);

		return "search";
	}
	
	//페이지 요청시 existence에서 0(ebook) 1(book) 구분값(값이 무조건 넘어와야함, ebook인지 book 페이지인지구분),페이지번호 pageNum(따로 넘어오는 값이 없으면 1페이지가 기본값)이 넘어온다
	@SuppressWarnings("unchecked")
	@RequestMapping("/page")
	public String page(Model model,HttpServletRequest request,int existence,@RequestParam(value = "pageNum", required = false, defaultValue="1") int pageNum) {
		HashMap<String, List<EBookVO>> tmp = new HashMap<String, List<EBookVO>>();
		if(existence==0) {
			tmp.put("page", service.pageList((ArrayList<EBookVO>) request.getAttribute("ebooklist"), pageNum));
			model.addAttribute("pageList", tmp);
		}else {
			tmp.put("page", service.pageList((ArrayList<EBookVO>) request.getAttribute("booklist"), pageNum));
			model.addAttribute("pageList", tmp);
		}
		return "결과페이지";
	}
	
	
	@RequestMapping(value="/main")
	public String Testo() {
		System.out.println("asd");
		return "search";
	}
	
	/////////////////////////////////////////////////////////////////이 밑으로는 수정 좀 헀습니다.
	@RequestMapping(value="/searchtmp", method= RequestMethod.GET)
	public String search(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws ClassNotFoundException, SQLException {
		String[] keywordArr = keyword.split(" ");
		
		System.out.println("검색 실행(param1:"+type+",param2:"+keyword+")");
		
		HashMap<String, List<EBookVO>> result = new HashMap<String, List<EBookVO>>();
		
		result.put("ebook", service.searchEbook(type, keywordArr));
		result.put("paper", service.searchPaperbook(type, keywordArr));
		
		model.addAttribute("result", result);
		
		return "searchtmp";
	}
	
}
