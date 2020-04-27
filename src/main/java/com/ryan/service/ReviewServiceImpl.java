package com.ryan.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ryan.domain.ReviewVO;
import com.ryan.mapper.ReviewMapper;

public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewMapper mapper;

	@Override
	public Boolean insertReview(ReviewVO review) {
		return mapper.insertReview(review)==1?true : false;
	}

	@Override
	public Boolean delecteReview(int reviewNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateReview(ReviewVO review) {
		// TODO Auto-generated method stub
		return null;
	}

}
