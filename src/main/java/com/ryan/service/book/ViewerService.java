package com.ryan.service.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ryan.domain.book.BookMarkVO;
import com.ryan.domain.book.EBookVO;

@Repository
public abstract interface ViewerService {
	//최상위 노드 가져옴
	public NodeList getRootNode(String filePath, String tagName) throws ParserConfigurationException, SAXException, IOException;
	//목차 가져오기
	public List<String> getIndex(String path) throws ParserConfigurationException, SAXException, IOException;
	//책 챕터별로 나누고 페이지로 나눔
	public List<List<String>> getBookChapters(String filePath) throws ParserConfigurationException, SAXException, IOException;
	//책 번호로 정보 가져오기
	public EBookVO getBookFilePath(@Param("booknumber") String bookNum) throws ClassNotFoundException, SQLException;
	//책갈피 추가
	public Boolean addBookMark(@Param("booknumber") String bookNum, @Param("pageNum") String pageNum, @Param("memberEmail") String memberEmail);
	//책갈피 삭제
	public Boolean removeBookMark(@Param("booknumber") String bookNum, @Param("pageNum") String pageNum, @Param("memberEmail") String memberEmail);
	//책갈피 불러오기. 임시
	public List<BookMarkVO> getBookMark(@Param("memberEmail") String memberEmail, @Param("booknumber") int booknumber);
}
