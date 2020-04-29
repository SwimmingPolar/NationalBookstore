package com.ryan.service.main;

import com.ryan.domain.ReviewVO;

public interface ReviewService {
	public Boolean insertReview(ReviewVO review);
	
	public Boolean delecteReview(int reviewNum);
	
	public Boolean updateReview(ReviewVO review);

}
