package com.ryan.service.book;

import java.util.List;

import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;

@Service
public class ViewerServiceImpl implements ViewerService {
	
	
	//최상위 루트
	@Override
	public NodeList getRootNode(String filePath, String tagName) {
		// TODO Auto-generated method stub
		return null;
	}
	//목차
	@Override
	public List<String> getIndex(String path) {
		// TODO Auto-generated method stub
		return null;
	}
	//페이지 나누기
	@Override
	public List<List<String>> getBookChapters(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

}
