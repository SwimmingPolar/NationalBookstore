package com.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.book.BookLikeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.member.MemberVO;

public interface AdminBookMapper {
	
	public List<EBookVO> statusLike();
	
	public List<EBookVO> statusLookup();
	
	public List<MemberVO> bestReader(String date);
	
	public int resetLookup();
	
	public EBookVO insertBook(EBookVO vo);
	
	public int updateBook(EBookVO vo);
	
	public int deleteBook(Map list);

}
