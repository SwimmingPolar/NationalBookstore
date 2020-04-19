package com.ryan.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ryan.domain.MemberVO;
import com.ryan.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CookieInterceptor extends HandlerInterceptorAdapter {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		
		if(member == null) {
			Cookie[] cookies = request.getCookies();
			
			for(Cookie c : cookies) {
				if(c.getName().equals("ryanMemberId")) {
					member.setMemberId(c.getValue());
				}
				if(c.getName().equals("ryanMemberNickName")) {
					member.setMemberNickName(c.getValue());
				}
			}
			
			if(member.getMemberId() != null && member.getMemberNickName() != null) {
				if(service.autoLogin(member)) { // true 회원정보가 존재
					session.setAttribute("ryanMember", member.getMemberId());
					return true;
				} else {
					response.sendRedirect("/member/login");
					return false;
				}
			} else {
				response.sendRedirect("/member/login");
				return false;
			}
			
		} else {
			return true;
		}
		
		
	}

	
	
	
}
