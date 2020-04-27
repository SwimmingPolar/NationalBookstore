package com.ryan.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@SessionAttributes({"ebookList","bookList","pageList","pageInfo"})
@RequestMapping("/search/*")
public class SearchController {
	
	@Autowired
	private SearchServiceImpl service;
	
	//검색
	@RequestMapping("/searchBook")
	//작가는 writer 책이름은 bookname으로 받음
	public String searchBook(Model model,@RequestParam(required = false , name = "writer") String writer,@RequestParam(required = false, name = "bookname") String bookname) {

		
		//검색결과 전체를 bookList vo로 세션으로 넘김(세션 가능)
		model.addAttribute("BookList", service.searchBookM(writer,bookname));

		System.out.println("크기는"+service.searchBookM(writer,bookname).size());
		
		return "결과페이지";
	}
	
	@RequestMapping("/classification/*")
	public void classification() {

	}
	
	//검색후 페이지 이동 관련 전부있음, 해당 페이지의 책목록 리스트를 pageList 세션으로 보냄
	//pageNum으로 클릭 페이지 정보 받아주세요
	@RequestMapping("/paging")
	public String paging(Model model,HttpServletRequest request,@RequestParam("pageNum") int Num) {
		request.getAttribute("bookList");
		

		return null;
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
