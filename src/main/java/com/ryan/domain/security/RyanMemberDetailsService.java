package com.ryan.domain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ryan.domain.member.MemberVO;
import com.ryan.mapper.MemberMapper;

import lombok.Setter;

public class RyanMemberDetailsService implements UserDetailsService {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO member = new MemberVO();
		member.setMemberEmail(username);
		
		
		MemberVO result = mapper.getLoginMemberInfo(member);
		
		if(result == null) {
			throw new UsernameNotFoundException(username);
		}
		
		
		return new RyanMember(result);
	}
	
	
	
	
}
