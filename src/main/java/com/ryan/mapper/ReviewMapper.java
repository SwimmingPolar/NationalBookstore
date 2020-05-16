package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.book.ReviewVO;

public interface ReviewMapper {
	public int insertReview(ReviewVO review);
	
	public int deleteReview(ReviewVO review);
	
	public int updateReview(ReviewVO review);
	
	public int searchRead(ReviewVO review);
	
	public int searchOrder(ReviewVO review);
	
	public int duplication(ReviewVO review);
	
	public ArrayList<ReviewVO> myReviewList(String memberEmail);
}
