package com.ryan.service.book;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.BookLikeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.HashtagVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.book.ReviewVO;
import com.ryan.domain.member.MemberVO;

public interface DetailBookService {
	
	//책 상세보기 페이지 조회
	public EBookVO searchEBook(int booknumber);
	
	//리뷰 조회
	public ArrayList<ReviewVO> searchReview(int booknumber);
	
	//관심 책 조회
	public List<EBookVO> interestbooks(int category);
	
	//좋아요 조회
	public int bookLike(int booknumber); 
	
	//평점 조회
	public int bookGrade(int booknumber);
	
	//태그 조회
	public List<HashtagVO> hashtag(int booknumber);
	
	//좋아요 한 사람들
	public ArrayList<MemberVO> likepeople(int booknumber);
	
	
	//해쉬태그 쿠기
	public boolean hashtagCookie(HashtagVO vo, HttpServletRequest request, HttpServletResponse response);
	
	public boolean hashtagCookieCheck(int booknumber, HttpServletRequest request);
	
	//평점입력
//	public double insertGrade(BookGradeVO vo);
	
	//좋아요 입력
	public int insertLike(int booknumber, Authentication auth);
	
	// 조회수 증가
	public void updateBookLookUp(EBookVO vo , HttpServletRequest request , HttpServletResponse response);

	//좋아요 눌렀는지 확인
	public boolean checkLike(int booknumber, Authentication auth);
	
}
