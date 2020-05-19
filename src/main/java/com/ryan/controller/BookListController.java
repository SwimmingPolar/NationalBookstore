package com.ryan.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.CartVO;
import com.ryan.service.main.MainPageService;
import com.ryan.service.main.SearchService;

@Controller
public class BookListController {
	@Autowired
	private SearchService sv;
	@Autowired
	private MainPageService service;
	
	@RequestMapping(value="/booklist")
	public String getBooks(@RequestParam(value="genre", required=false) String genre, @RequestParam(value="sub_genre", required=false) String sub_genre, @RequestParam(value="page", required=false) String page, @RequestParam(value="sort", required=false) String sort, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("전체책목록(param1:"+genre+";param2:"+sub_genre+";param3:"+page+";param4:"+sort+")");
		
		List<EBookVO> result = new ArrayList<EBookVO>();
		result = sv.getFilterSearch(genre, sub_genre, page, sort);
		int length = sv.getFilterSearchCount(genre, sub_genre, page).size();
		
		model.addAttribute("result", result);
		model.addAttribute("length", length);
		return "booklist";
	}
	
	@RequestMapping(value="/search")
	public String searchnew(@RequestParam(value="type", required=false) String type, @RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="page", required=false) String page, HttpSession session, Model model) throws ClassNotFoundException, SQLException {
		System.out.println(String.format("검색 실행 (param1:%s;param2:%s;param3:%s)", type, keyword, page));
		if(type == null) {
			type = "BOOK_TITLE";
		}
		String[] keywordArr;
		if(keyword == null) {
			System.out.println("keyword is null");
			keywordArr = new String[] {""};
			System.out.println("검색어는 기본으로'"+keywordArr[0]+"'로 지정될 것입니다.");
		} else {
			System.out.println("keyword is not null");
			keywordArr = keyword.split(" ");
		}
		int ebookCount = sv.ebookCount(type, keywordArr, page).size();
		int paperCount = sv.paperCount(type, keywordArr, page).size();
		model.addAttribute("ebook", sv.ebook(type, keywordArr, page));
		model.addAttribute("paper", sv.paper(type, keywordArr, page));
		model.addAttribute("ebookCount", ebookCount);
		model.addAttribute("paperCount", paperCount);
		model.addAttribute("resultCount", (ebookCount+paperCount));
		return "search";
	}

	@PostMapping(value="/search/cart")
	@ResponseBody
	public Map<String, String> Carto(CartVO[] cartList) {
		//System.out.println(String.format("장바구니 담기 요청(param:%s)", ryanMember));
		Map<String, String> resultMessage = new HashMap<String, String>();
		resultMessage.put("doneM", "통신 성공");
		resultMessage.put("failM", "통신 실패");
		if(cartList.length!=0) {
			for(CartVO vo : cartList) {
				System.out.println(vo);
			}
		} else {
			System.out.println("리스트가 비어있습니다.");
		}
		return resultMessage;
	}
	
	@RequestMapping(value="/paper/searchbak")
	public String PaperSearch(@RequestParam(value="type", required=false) String type, @RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="page", required=false) String page, HttpSession session, Model model) throws ClassNotFoundException, SQLException {
		System.out.println(String.format("종이책 검색 실행 (param1:%s;param2:%s;param3:%s)", type, keyword, page));
		if(type == null) {
			type = "BOOK_TITLE";
		}
		String[] keywordArr;
		if(keyword == null) {
			System.out.println("keyword is null");
			keywordArr = new String[] {""};
			System.out.println("검색어는 기본으로'"+keywordArr[0]+"'로 지정될 것입니다.");
		} else {
			System.out.println("keyword is not null");
			keywordArr = keyword.split(" ");
		}
		model.addAttribute("paper", sv.paper(type, keywordArr, page));
		model.addAttribute("paperCount", sv.paperCount(type, keywordArr, page).size());
		return "paper";
	}
	//종이책 구매 검색
	@RequestMapping(value="/paper/search")
	public String getPaperByGenre(@RequestParam(value="type", required=false) String type, @RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="page", required=false) String page, @RequestParam(value="genre", required=false) String genre, HttpSession session, Model model) {
		System.out.println(String.format("종이책 검색 실행 (param1:%s;param2:%s;param3:%s)", type, keyword, page));
		if(type == null) {
			type = "BOOK_TITLE";
		}
		String[] keywordArr;
		if(keyword == null) {
			System.out.println("keyword is null");
			keywordArr = new String[] {""};
			System.out.println("검색어는 기본으로'"+keywordArr[0]+"'로 지정될 것입니다.");
		} else {
			System.out.println("keyword is not null");
			keywordArr = keyword.split(" ");
		}
		
		model.addAttribute("counto", sv.getGenreCount(type, keywordArr, page, genre));
		model.addAttribute("paper", sv.getPaperByGenre(type, keywordArr, page, genre));
		model.addAttribute("paperCount", sv.getPaperByGenreCount(type, keywordArr, page, genre).size());
		return "paper";
	}
	
	@RequestMapping(value="/paper")
	public String Paper() {
		return "paper";
	}
	
	//베스트셀러
	@RequestMapping(value="/best")
	public String BestSeller(@RequestParam(value="time", defaultValue="주간") String time, @RequestParam(value="category", defaultValue="소설") String category, Model model) {
		model.addAttribute("result", service.getBestSeller(time, category));
		return "best";
	}
	//@GetMapping("/best")
	//public @ResponseBody ArrayList<EBookVO> responseBestSeller(@RequestParam("time") String time, @RequestParam("category") String category){
	//	return service.getBestSeller(time, category);
	//}
	
}
