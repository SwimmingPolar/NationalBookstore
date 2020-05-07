package com.ryan.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class FollowServiceImpl implements FollowService{

	@Setter(onMethod_ = {@Autowired})
	private FollowMapper mapper;
	
	
	
	
	
}
