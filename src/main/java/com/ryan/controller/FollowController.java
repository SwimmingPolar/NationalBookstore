package com.ryan.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.domain.member.FollowVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.service.member.FollowService;

import lombok.Setter;

@RestController
@RequestMapping("/follow/*")
public class FollowController {
	
	@Setter(onMethod_ = {@Autowired})
	private FollowService service;
	
	@RequestMapping("/requestFollow")
	public Boolean requestFollow(@RequestParam("following") String following, Authentication auth ) {

		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		
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
	
	
	@GetMapping("/deleteFollow")
	public Boolean deleteFollow(@RequestParam("following") String following, Authentication auth) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		
		if(service.followCheck(member.getMemberEmail(), following)) {
			if(service.deleteFollow(member.getMemberEmail(), following)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	/*
	 * //내가 팔로우한 사람들 보여주기
	 * 
	 * @PostMapping("/myfollowing") public ArrayList<FollowVO>
	 * getMyFollowing(Authentication auth){
	 * 
	 * RyanMember ryanMember = (RyanMember) auth.getPrincipal(); MemberVO member =
	 * ryanMember.getMember();
	 * 
	 * return service.getMyFollowing(member.getMemberEmail()); }
	 */
	//나를 팔로우 한 사람
	@PostMapping("/myfollower")
	public ArrayList<FollowVO> getMyFollower(Authentication auth){
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		return service.getMyFollower(member);
	}
	
	
	

}
