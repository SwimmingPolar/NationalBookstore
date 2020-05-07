package com.admin.service.book;

import java.util.List;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.member.MemberVO;

public interface AdminBookService {
	
	public List<EBookVO> statusLike();
	
	public List<EBookVO> statusLookup();
	
	public void resetLookup();
	
	public List<MemberVO> bestReader(String date);
	
	public EBookVO insertBook(EBookVO vo);
	
	public Boolean updateBook(EBookVO vo);
	
	public Boolean deleteBook(int[] booknum);
	
	
	
}
