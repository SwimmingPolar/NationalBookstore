package com.ryan.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ryan.domain.book.ReviewVO;
import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.BookLikeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.HashtagVO;
import com.ryan.domain.member.MemberVO;

public interface DetailBookMapper {	
	
	//책 상세보기 조회
	public EBookVO searchEBook(int booknumber);
	
	//상세보기 페이지 리뷰조회
	public ArrayList<ReviewVO> searchReview(int booknumber);	
	
	//상세보기 페이지 관심책 불러오기
	public List<EBookVO> interestbooks(int category);
	
	//좋아요 숫자 조회
	public int bookLike(int booknumber);
	
	//좋아요 전체 조회
	public ArrayList<BookLikeVO> bookLikeList(int booknumber);/////
	
	//평점 조회
	public int bookGrade(int booknumber);
	
	//태그 조회
	public List<HashtagVO> hashtag(int booknumber);
	
	//좋아요 한 사람들
	public ArrayList<MemberVO> likepeople(int booknumber);
	
	
	//해쉬태그 입력
	public int insertHashtag(HashtagVO vo);
	
	//평점 입력
//	public int insertGrade(BookGradeVO vo);
	
	//좋아요 입력
	public int insertLike(BookLikeVO vo);

	//좋아요 취소
	public int deleteLike(int likenum);
	
	//조회수 증가 
	public int updateBookLookUp(EBookVO vo);
	
}
