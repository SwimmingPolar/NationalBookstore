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
		
		log.info("쿠키 인터셉터의 멤버값 : " + member);
		if(member == null) {
			member = new MemberVO();
			Cookie[] cookies = request.getCookies();
			log.info("쿠키의값: " + cookies);
			if(cookies != null ) {
				log.info("쿠키 확인 for 문 확인전");
				for(Cookie c : cookies) {
					log.info("쿠키 for문 돌아가는중");
					log.info("현재 쿠키의 이름: " + c.getName());
					if(c.getName().equals("ryanMemberId")) {
						member.setMemberId(c.getValue());
						log.info("쿠기값: " + c.getValue());
					}
					if(c.getName().equals("ryanMemberNickName")) {
						member.setMemberNickName(c.getValue());
						log.info("쿠키값: " + c.getValue());
					}
				}
			}
			
			
			if(member.getMemberId() != null && member.getMemberNickName() != null) {
				if(service.autoLogin(member)) { // true 회원정보가 존재
					log.info("쿠키로 세션생성");
					session.setAttribute("ryanMember", member);
					return true;
				} 
				
			} 
			return true;
		} else {
			return true;
		}
		
		
	}

	
	
	
}
