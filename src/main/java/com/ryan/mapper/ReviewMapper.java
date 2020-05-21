package com.ryan.mapper;

import java.util.ArrayList;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.ReviewVO;

public interface ReviewMapper {
	public int insertReview(ReviewVO review);
	//throws SQLException
	public int deleteReview(int reviewNum);
	
	public int updateReview(ReviewVO review);
	
	public int searchRead(ReviewVO review);
	
	public int searchOrder(ReviewVO review);
	
	public int duplication(ReviewVO review);
	
	public int test();
	
	public ArrayList<ReviewVO> myReviewList(String memberEmail);
	
	public int insertGrade(BookGradeVO grade);
	
	//회원 탈퇴시 내가 작성한 포스트 수 불러오기
	public int countMyPost(String memberEmail);
}
