package com.ryan.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ryan.domain.member.FollowVO;
import com.ryan.domain.member.MemberVO;

public interface FollowMapper {
	
	//팔로우 하기
	public int insertFollow(@Param("follower") String follower ,@Param("following") String following);
	
	//팔로우 취소
	public int deleteFollow(@Param("follower") String follower ,@Param("following") String following);
	
	//내가 팔로우한 사람들 보여주기
	public ArrayList<FollowVO> getMyFollowing(MemberVO member);
	
	//나를 팔로우 한 사람들 보여주기
	public ArrayList<FollowVO> getMyFollower(MemberVO member);
	
	//혹시모를 검증?
	public int followCheck(@Param("follower") String follower ,@Param("following") String following);
	
	//나를 팔로우 한 사람들 수
	public int countFollower(MemberVO member);
	
}
