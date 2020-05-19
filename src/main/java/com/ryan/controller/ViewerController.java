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
	public String ViewerMain(String booknumber, Model model) throws ParserConfigurationException, SAXException, IOException {
		String path = null;
		//String path = "";
		try {
			path = "../eclipse_workspace/NationalBookstore/src/main/webapp/"+sv.getBookFilePath(booknumber).getBookPath();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("chapter", sv.getBookChapters(path));
		model.addAttribute("index", sv.getIndex(path));
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
}
