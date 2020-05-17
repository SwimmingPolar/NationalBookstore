package com.ryan.service.main;


import java.util.ArrayList;

import com.ryan.domain.book.ReviewVO;
import com.ryan.domain.member.MemberVO;

public interface ReviewService {
	
	public Boolean insertReview(ReviewVO review);
	
	public Boolean delecteReview(ReviewVO review);
	
	public Boolean updateReview(ReviewVO review);
	
	public ArrayList<ReviewVO> myReviewList(String memberEmail);
}
