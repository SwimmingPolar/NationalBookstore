package com.admin.domain.board;

import lombok.Data;

@Data
public class PageVO {
	//현재 페이지
	private int page;
	
	//한페이지당 보여줄 게시물개수
	private int viewSize=10;
	
	//현재 속한페이지그룹 0부터 시작 아래 <와 >사이 숫자를 하나의 그룹으로 묶음
	private int group;
	
	//페이지 그룹당 보여줄 갯수 <와 >사이 몇개의 페이지를 넣을지
	private int pagePerGroup=10;
	
	//페이지그룹 시작번호
	private int startG;
	
	//페이지그룹 끝번호
	private int endG;
	
	//총개시물수
	private int tContent;
	
	//총페이지수
	private int tPage;
	
	//요청페이지 첫번째 게시물 번호
	private int startContent;
	
	public PageVO() {
		super();
	}
	
	public PageVO(int page,int tContent) {
		
		this.tContent=tContent;
		
		//전체 페이지수
		tPage=(tContent+viewSize-1)/viewSize;
		
		if(page<1)
			page=1;
		if(page>tPage)
			page=tPage;
		
		this.page=page;
		
		//요청페이지가 속한그룹
		group=(page-1)/pagePerGroup;
		
		//속한그룹의 첫번째 페이지
		startG=page*pagePerGroup+1;
		startG=startG<1?1:startG;
		
		//속한그룹의 마지막페이지
		endG=startG+pagePerGroup-1;
		endG=endG<tPage?endG:tPage;
		
		//요청페이지 첫번째 게시물번호
		startContent=(page-1)*viewSize;
		
	}
}
