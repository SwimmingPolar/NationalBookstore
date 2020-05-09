package com.admin.domain.board;

import lombok.Data;

@Data
public class PageVO {
	//현재 페이지
	private int page;
	
	//한페이지당 보여줄 개수
	private int viewSize;
	
	//현페이지 시작개시물번호
	private int startPage;
	
	//현페이지 끝개시물 번호
	private int endPage;
	
	//<,<< 버튼정보저장
	private int pre;
	
	//>,>> 버튼정보저장
	private int next;
}
