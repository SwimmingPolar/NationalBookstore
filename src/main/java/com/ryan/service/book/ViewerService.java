package com.ryan.service.book;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.w3c.dom.NodeList;

@Repository
public abstract interface ViewerService {
	//최상위 노드 가져옴
	public NodeList getRootNode(String filePath, String tagName);
	//목차 가져오기
	public List<String> getIndex(String path);
	//책 챕터별로 나누고 페이지로 나눔
	public List<List<String>> getBookChapters(String filePath);
}
