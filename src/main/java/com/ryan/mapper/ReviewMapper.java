package com.ryan.mapper;

import com.ryan.domain.ReviewVO;

public interface ReviewMapper {
	public int insertReview(ReviewVO review);
	
	public int deleteReview(ReviewVO review);
	
	public int updateReview(ReviewVO review);
	
	public int searchRead(ReviewVO review);
	
	public int searchOrder(ReviewVO review);
	
	public int duplication(ReviewVO review);

}
