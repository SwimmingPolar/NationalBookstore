package com.ryan.service.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.ReviewVO;
import com.ryan.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewMapper mapper;

	@Override
	public Boolean insertReview(ReviewVO review) {
		int flag=0;
		if(mapper.duplication(review)>0)
			return false;
		else {
			flag=(int)mapper.searchOrder(review)+(int)mapper.searchRead(review);
			if(flag>0) {
				return mapper.insertReview(review)==1?true : false;
			}else
				return false;
		}
	}

	@Override
	public Boolean delecteReview(ReviewVO review) {
		if(mapper.duplication(review)>0)
			return mapper.deleteReview(review)==1?true:false;
		else
			return false;
	}

	@Override
	public Boolean updateReview(ReviewVO review) {
		if(mapper.duplication(review)>0)
			return mapper.updateReview(review)==1?true:false;
		else
			return false;
	}

	@Override
	public ArrayList<ReviewVO> myReviewList(String memeberEmail) {
		return mapper.myReviewList(memeberEmail);
	}
}
