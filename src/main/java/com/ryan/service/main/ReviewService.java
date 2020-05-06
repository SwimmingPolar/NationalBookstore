package com.ryan.service.main;

import com.ryan.domain.ReviewVO;
import com.ryan.domain.member.MemberVO;

public interface ReviewService {
	
	public Boolean insertReview(ReviewVO review);
	
	public Boolean delecteReview(ReviewVO review);
	
	public Boolean updateReview(ReviewVO review);
}
