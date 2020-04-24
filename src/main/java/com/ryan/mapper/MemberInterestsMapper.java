package com.ryan.mapper;

import org.apache.ibatis.annotations.Param;

public interface MemberInterestsMapper {
	
	public int insertInterests(@Param("memberEmail") String memberEmail, int[] categoryArray);
	
}
