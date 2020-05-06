package com.ryan.mapper;

import com.ryan.domain.ReviewVO;

public interface ReviewMapper {
	public int insertReview(ReviewVO review);
	
	public int deleteReview(String memberEmail,int reviewNum);
	
	public int updateReview();
	
	public int searchRead(String memberEmail,int reviewNum);
	
	public int searchOrder(String memberEmail,int reviewNum);
	
	public int duplication(String memberEmail,int reviewNum);

}
