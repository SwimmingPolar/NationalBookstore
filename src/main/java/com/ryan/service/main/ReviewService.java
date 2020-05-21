package com.ryan.service.main;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.ReviewVO;

public interface ReviewService {
	
	public Boolean insertReview(ReviewVO review);
	
	public Boolean delecteReview(int reviewNum);
	
	public Boolean updateReview(ReviewVO review);
	
	public ArrayList<ReviewVO> myReviewList(String clickId);
	
	public Boolean insertGrade(BookGradeVO grade);
	
	//회원 탈퇴 시 내가 작성한 포스트 수 불러오기
	public int countMyPost(String memberEmail);
}
