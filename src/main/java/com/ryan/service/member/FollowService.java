package com.ryan.service.member;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.Authentication;

import com.ryan.domain.member.FollowVO;
import com.ryan.domain.member.MemberVO;

public interface FollowService {

	public Boolean insertFollow(String follower ,String following);
	
	public Boolean deleteFollow(String follower ,String following);
	
	public  ArrayList<FollowVO> getMyFollowing(String clickId, Authentication auth);
	
	public ArrayList<FollowVO> getMyFollower(MemberVO member);
	
	public Boolean followCheck( String follower , String following);
	
	public int countFollow(String clickId, Authentication auth);
}
