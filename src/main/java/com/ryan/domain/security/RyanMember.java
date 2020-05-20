package com.ryan.domain.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ryan.domain.member.MemberVO;

import lombok.Getter;

@Getter
public class RyanMember extends User {
	
	private static final long serialVersionUID = 1L;
	private MemberVO member;
	
	public RyanMember(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public RyanMember(MemberVO member) {
		
		super(member.getMemberEmail(), member.getMemberPw(), member.getMemberAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.member = member;
		
	}
	
}
