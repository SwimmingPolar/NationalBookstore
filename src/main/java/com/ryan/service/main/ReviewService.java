package com.ryan.service.main;

import com.ryan.domain.ReviewVO;
import com.ryan.domain.member.MemberVO;

public interface ReviewService {
	public Boolean insertReview(ReviewVO review,MemberVO member);
	
	public Boolean delecteReview(int reviewNum,MemberVO member);
	
	public Boolean updateReview(ReviewVO review,MemberVO member);

}
