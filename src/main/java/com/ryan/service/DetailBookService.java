package com.ryan.service;

import java.util.List;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.domain.HashtagVO;
import com.ryan.domain.ReviewVO;

public interface DetailBookService {
	
	//책 상세보기 페이지 조회
	public EBookVO searchEBook(int booknumber);
	
	//리뷰 조회
	public ReviewVO searchReview(int booknumber);
	
	//관심 책 조회
	public List<EBookVO> interestbooks(String category);
	
	//좋아요 조회
	public BookLikeVO bookLike(int booknumber); 
	
	//평점 조회
	public BookGradeVO bookGrade(int booknumber);
	
	//태그 조회
	public HashtagVO hashtag(int booknumber);
	
	//좋아요 한 사람들
	public MemberVO likepeople(String id);
	
	
	//해쉬태그 입력
	public int insertHashtag(HashtagVO vo);
}
