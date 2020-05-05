package com.ryan.service.main;

import com.ryan.domain.ReviewVO;
import com.ryan.domain.member.MemberVO;

public interface ReviewService {
	public Boolean insertReview(ReviewVO review,MemberVO member);
	
	public Boolean delecteReview(String memberEmail,int bookNum);
	
	public Boolean updateReview(ReviewVO review,MemberVO member);
	
	public Boolean duplicationChk(String memberEmail,int bookNum);

}
