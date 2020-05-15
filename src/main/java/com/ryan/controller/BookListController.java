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
import com.ryan.domain.payment.CartVO;
import com.ryan.service.main.SearchService;

@Controller
public class BookListController {
	@Autowired
	private SearchService sv;
	
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
		HashMap<String, List<EBookVO>> result = new HashMap<String, List<EBookVO>>();
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
		result.put("ebook", sv.ebook(type, keywordArr, page));
		result.put("paper", sv.paper(type, keywordArr, page));
		model.addAttribute("result", result);
		
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
	public Map<String, String> Carto(@RequestBody CartVO[] cartList) {
		System.out.println("장바구니 담기 요청.");
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
}
