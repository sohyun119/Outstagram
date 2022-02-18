package com.SH.outstagram.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component // spring bin 에 클래스 등록 (Autowired 사용가능)
public class PermissionInterceptor implements HandlerInterceptor{
	
	// 1. 요청이 들어 올 때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		// 로그인 정보
		HttpSession session = request.getSession();
		
		// 현재 요청한 url에 path == uri 
		String uri = request.getRequestURI();
		
		// 로그인 상태
		if(session.getAttribute("userId") != null) {
			// 로그인 화면과, 회원가입 화면 접근 못하게
			// 타임라인 화면으로 이동
			
			if(uri.startsWith("/user")) {
				// 타임라인 페이지로 이동
				response.sendRedirect("/post/timeline_view");
				return false; // 목표로 했던 controller 로 가려는 것을 취소시킴
			}
		}
		// 비로그인 상태
		else {
			// 리스트 화면, 디테일 화면
			// 로그인 페이지로 이동시키기
			
			if(uri.startsWith("/post")) {
				// 로그인 페이지로 이동
				response.sendRedirect("/user/signin_view");
				return false;
			}
		}
		
		return true;
	}
	
	// 2. response 처리 할 때 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) {
		
	}
	
	
	// 3. 모든 것이 완료 되었을 때
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		
	}

}
