package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.ReviewVO;

public interface ReviewMapper {
	public int insertReview(ReviewVO review);
	//throws SQLException
	public int deleteReview(ReviewVO review);
	
	public int updateReview(ReviewVO review);
	
	public int searchRead(ReviewVO review);
	
	public int searchOrder(ReviewVO review);
	
	public int duplication(ReviewVO review);
	
	public int test();
	
	public ArrayList<ReviewVO> myReviewList(String memberEmail);
	
	public int insertGrade(BookGradeVO grade);
}
