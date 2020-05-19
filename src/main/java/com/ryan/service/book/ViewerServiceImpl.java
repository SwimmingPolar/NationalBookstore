package com.ryan.service.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ryan.domain.book.BookMarkVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.mapper.ViewerMapper;

@Service
public class ViewerServiceImpl implements ViewerService {
	@Autowired
	ViewerMapper mapper;
	
	//최상위 루트
	@Override
	public NodeList getRootNode(String filePath, String tagName) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(filePath);
		
		doc.normalize();
		
		Element root = doc.getDocumentElement();
		
		NodeList nodeList = root.getElementsByTagName(tagName);
		
		return nodeList;
	}
	//목차
	@Override
	public List<String> getIndex(String path) throws ParserConfigurationException, SAXException, IOException {
		String tagName = "index";
		List<String> indexList = new ArrayList<String>();
		
		NodeList nodeList = getRootNode(path, "chapter");
		
		for(int index=0;index<nodeList.getLength();index++) {
			Element el = (Element)nodeList.item(index);
			String title = el.getElementsByTagName("title").item(0).getTextContent();
			indexList.add(title);
		}
		return indexList;
	}
	//페이지 나누기
	@Override
	public List<List<String>> getBookChapters(String filePath) throws ParserConfigurationException, SAXException, IOException {
		List<List<String>> chapter = new ArrayList<List<String>>();
		List<String> page = new ArrayList<String>();
		
		long startTime = System.currentTimeMillis();
		NodeList nodeList = getRootNode(filePath, "chapter");
		for(int index=0;index<nodeList.getLength();index++) {
			Element el = (Element)nodeList.item(index);
			String title = "<h3>"+el.getElementsByTagName("title").item(0).getTextContent()+"</h3>";
			String content = el.getElementsByTagName("content").item(0).getTextContent();
			content = content.replace("\t",  "").replace("\n", "").replace("   ", "");
			int counto = 600;
			int a = content.length()/counto;
			
			int begin = 0;
			int end = 0;
			if(content.length()>counto) {
				for(int counter=0;counter<a;counter++) {
					begin = counter * counto;
					end = begin + counto;
					if(begin==0) {
						page.add(title+content.substring(begin, end));
					} else {
						page.add(content.substring(begin, end)+"<br />");
					}
				}
				page.add(content.substring(end, content.length()));
			} else {
				page.add(content);
			}
			chapter.add(page);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간:"+(endTime-startTime)+"ms");
		return chapter;
	}
	@Override
	public EBookVO getBookFilePath(@Param("booknumber") String bookNum) throws ClassNotFoundException, SQLException {
		return mapper.getBookFilePath(bookNum);
	}
	@Override
	public Boolean addBookMark(@Param("booknumber") String bookNum, @Param("page") String page, @Param("pageStatus") String pageStatus) {
		return mapper.addBookMark(bookNum, page, pageStatus);
	}
	@Override
	public List<BookMarkVO> getBookMark() {
		return mapper.getBookMark();
	}

}
