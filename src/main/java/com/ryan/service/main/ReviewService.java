package com.ryan.service.main;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ryan.domain.book.ReviewVO;

public interface ReviewService {
	
	public Boolean insertReview(ReviewVO review);
	
	public Boolean delecteReview(ReviewVO review);
	
	public Boolean updateReview(ReviewVO review);
	
	public ArrayList<ReviewVO> myReviewList(HttpSession session);
	
	public Boolean insertGrade(int bookNum);
}
