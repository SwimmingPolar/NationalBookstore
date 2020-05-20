package com.ryan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.BookMarkVO;
import com.ryan.domain.book.EBookVO;

public abstract interface ViewerMapper {
	//책 번호로 정보 가져오기
	public EBookVO getBookFilePath(@Param("booknumber") String bookNum);
	//책갈피 추가
	public Boolean addBookMark(@Param("booknumber") String bookNum, @Param("pageNum") String pageNum, @Param("memberEmail") String memberEmail);
	//책갈피 삭제
	public Boolean removeBookMark(@Param("booknumber") String bookNum, @Param("pageNum") String pageNum, @Param("memberEmail") String memberEmail);
	//책갈피 불러오기.
	public List<BookMarkVO> getBookMark(@Param("memberEmail") String memberEmail, @Param("booknumber") int booknumber);
}
