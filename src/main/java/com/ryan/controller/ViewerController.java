package com.ryan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.ryan.domain.book.BookMarkVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.service.book.ViewerService;

@Controller
public class ViewerController {
	@Autowired
	ViewerService sv;
	
	@RequestMapping(value="/viewer")
	public String ViewerMain(@ModelAttribute("booknumber") String booknumber, Model model, HttpServletRequest request) throws ParserConfigurationException, SAXException, IOException {
		String path = null;
		//MemberVO memberInfo = (MemberVO)session.getAttribute("ryanMember");
		MemberVO memberInfo = new MemberVO();
		memberInfo.setMemberEmail("abc1234@naver.com");
		System.out.println(memberInfo);
		try {
			path = request.getSession().getServletContext().getRealPath(sv.getBookFilePath(booknumber).getBookPath());
			//path = "../eclipse_workspace/NationalBookstore/src/main/webapp/"+sv.getBookFilePath(booknumber).getBookPath();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("chapter", sv.getBookChapters(path));
		model.addAttribute("index", sv.getIndex(path));
		if(memberInfo != null)
			model.addAttribute("bookmark", sv.getBookMark(memberInfo.getMemberEmail(), Integer.parseInt(booknumber))); //북마크
		try {
			model.addAttribute("book", sv.getBookFilePath(booknumber));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "viewer2";
	}
	
	//북마크 추가
	//@RequestMapping(value="/addBookmark")
	//@ResponseBody
	//public boolean AddBookMark(String bookNum, String pageNum, String memberEmail) {
	//	System.out.println("북마크 추가 시도");
	//	return sv.addBookMark(bookNum, pageNum, memberEmail);
	//}
	@RequestMapping(value="/addBookmark")
	@ResponseBody
	public List<BookMarkVO> AddBookMark(String bookNum, String pageNum, String memberEmail) {
		System.out.println("북마크 추가");
		List<BookMarkVO> bookmarkList = null;
		boolean chk = sv.addBookMark(bookNum, pageNum, memberEmail);
		if(chk == true) {
			bookmarkList = sv.getBookMark(memberEmail, Integer.parseInt(bookNum));
		}
		return bookmarkList;
	}
	
	@RequestMapping(value="/removeBookmark")
	@ResponseBody
	public List<BookMarkVO> removeBookMark(String bookNum, String pageNum, String memberEmail) {
		System.out.println("북마크 삭제");
		List<BookMarkVO> bookmarkList = null;
		boolean chk = sv.removeBookMark(bookNum, pageNum, memberEmail);
		if(chk == true) {
			bookmarkList = sv.getBookMark(memberEmail, Integer.parseInt(bookNum));
		}
		return bookmarkList;
	}
}
