package com.ryan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.ryan.service.book.ViewerService;

@Controller
public class ViewerController {
	@Autowired
	ViewerService sv;
	
	@RequestMapping(value="/viewer")
	public String ViewerMain(String bookNum, Model model) throws ParserConfigurationException, SAXException, IOException {
		//String path = "../eclipse_workspace/WebLib/src/main/webapp/resources/xml/book3.xml";
		String path = "";
		try {
			path = sv.getBookFilePath(bookNum).getBookPath();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("chapter", sv.getBookChapters(path));
		model.addAttribute("index", sv.getIndex(path));
		return "viewer2";
	}
}
