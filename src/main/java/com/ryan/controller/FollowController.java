package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.domain.member.FollowVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.service.member.FollowService;

import lombok.Setter;

@RestController
@RequestMapping("/follow/*")
public class FollowController {
	
	@Setter(onMethod_ = {@Autowired})
	private FollowService service;
	
	@RequestMapping("/request")
	public Boolean requestFollow(@RequestParam("following") String following, HttpSession session ) {
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		// return false == 이미 팔로우 한사람
		// 검증을 위해서
		if(!service.followCheck(member.getMemberEmail(), following)) {
			if(service.insertFollow(member.getMemberEmail(), following)) {
				return true;
			} else {
				return false;
			}
		} else { 
			return false;
		}
	
	}
	
	
	@PostMapping("/delete")
	public Boolean deleteFollow(@RequestParam("following") String following, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		if(!service.followCheck(member.getMemberEmail(), following)) {
			if(service.deleteFollow(member.getMemberEmail(), following)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	//내가 팔로우한 사람들 보여주기
	@PostMapping("/myfollowing")
	public ArrayList<FollowVO> getMyFollowing(HttpSession session){
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		return service.getMyFollowing(member);
	}
	
	@PostMapping("/myfollower")
	public ArrayList<FollowVO> getMyFollower(HttpSession session){
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		return service.getMyFollower(member);
	}
	
	
	

}
