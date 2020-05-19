package com.ryan.domain.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RyanLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("ROLE NAMES: " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) { //사용자 권한이 어드민이면 어드민페이지로이동
			response.sendRedirect("아직주소모름");
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) { //회원이면 메인페이지
			response.sendRedirect("/");
			return;
		}
		
		response.sendRedirect("/member/signin");		
	}
	
	
	
}
