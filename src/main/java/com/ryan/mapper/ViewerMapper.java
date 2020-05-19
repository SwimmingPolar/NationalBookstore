package com.ryan.mapper;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.EBookVO;

public abstract interface ViewerMapper {
	//책 번호로 정보 가져오기
	public EBookVO getBookFilePath(@Param("booknumber") String bookNum);
}
