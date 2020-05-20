package com.ryan.service.member;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ryan.domain.member.FollowVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.mapper.FollowMapper;

import lombok.Setter;



@Service
public class FollowServiceImpl implements FollowService{

	@Setter(onMethod_ = {@Autowired})
	private FollowMapper mapper;

	@Override
	public Boolean insertFollow(String follower, String following) {
		return mapper.insertFollow(follower, following)==1 ? true : false;
	}

	@Override
	public Boolean deleteFollow(String follower, String following) {
		return mapper.deleteFollow(follower, following) ==1 ? true : false;
	}

	@Override
	public ArrayList<FollowVO> getMyFollowing(MemberVO member) {
		return mapper.getMyFollowing(member);
	}

	@Override
	public ArrayList<FollowVO> getMyFollower(MemberVO member) {
		return mapper.getMyFollower(member);
	}

	@Override
	public Boolean followCheck(String follower, String following) {
		return mapper.followCheck(follower, following)>=1? true : false;
	}

	@Override
	public int countFollow(String clickId,Authentication auth) {
		// TODO Auto-generated method stub
		if(clickId != null && clickId != "") {
			return mapper.countFollower(clickId);
		}else {
			RyanMember ryanmember = (RyanMember) auth.getPrincipal();
			MemberVO member = (MemberVO) ryanmember.getMember();
			return mapper.countFollower(member.getMemberEmail());
		}
	}
	
	
	
	
}
