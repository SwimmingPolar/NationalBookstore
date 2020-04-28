package com.ryan.controller;


//github.com/SwimmingPolar/NationalBookstore.git
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

import com.ryan.domain.EBookVO;
import com.ryan.service.SearchServiceImpl;

@Controller
//순서대로 e북 리스트, 현물책 리스트, 요청페이지에 띄울 리스트 정보가 들어있다
@SessionAttributes({"ebookList","bookList","pageList"})
@RequestMapping("/search/*")
public class SearchController {
	
	@Autowired
	private SearchServiceImpl service;
	
	private ArrayList<EBookVO> tmpArr;
	
	//검색후 e북과 현물북 리스트를 세션에 저장한다
	@RequestMapping("/searchBook")
	//작가는 writer 책이름은 bookname으로 받음
	public String searchBook(Model model,@RequestParam(required = false , name = "writer") String writer,@RequestParam(required = false, name = "bookname") String bookname) {
		tmpArr=service.searchBookM(writer,bookname);
		
		//검색결과 전체를 bookList vo로 세션으로 넘김(세션 가능)
		model.addAttribute("ebookList", tmpArr);
		model.addAttribute("bookList",service.bookList(tmpArr));
		
		System.out.println("크기는"+tmpArr.size());
		
		return "결과페이지";
	}
	
	//현물 책 검색결과 리스트, 요청 페이지가 몇패이지인지 정보를 받고 요청 페이지에 맞는 책리스트를 model에 VO array이로 보냄
	@SuppressWarnings("unchecked")
	@RequestMapping("/book")
	public String book(Model model,HttpServletRequest request,@RequestParam("pageNum") int pageNum) {
		HttpSession session = request.getSession();
		tmpArr=(ArrayList<EBookVO>) session.getAttribute("bookList");
		model.addAttribute("pageList", tmpArr);
		
		return "페이지";
	}
	
	//e북 요청페이지 리스트 이하동문
	@SuppressWarnings("unchecked")
	@RequestMapping("/ebook")
	public String ebook(Model model,HttpServletRequest request,@RequestParam("pageNum") int pageNum) {
		HttpSession session = request.getSession();
		tmpArr=(ArrayList<EBookVO>) session.getAttribute("ebookList");
		model.addAttribute("pageList", tmpArr);
		
		return "페이지";
	}
	
	@RequestMapping("/test123")
	public String sadsad() {
		return "test";
	}
	
	/////////////////////////////////////////////////////////////////이 밑으로는 수정 좀 헀습니다.
	@RequestMapping(value="/main")
	public String Testo() {
		return "search";
	}
	@RequestMapping(value="/search", method= RequestMethod.GET)
	public String search(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws ClassNotFoundException, SQLException {
		
		System.out.println("검색 실행(param1:"+type+",param2:"+keyword+")");
		
		HashMap<String, List<EBookVO>> result = new HashMap<String, List<EBookVO>>();
		String[] keywordArr = keyword.split(" ");
		
		result.put("ebook", service.searchEbook(type, keywordArr));
		result.put("paper", service.searchPaperbook(type, keywordArr));
		
		model.addAttribute("result", result);
		
		return "search";
	}
	
}
