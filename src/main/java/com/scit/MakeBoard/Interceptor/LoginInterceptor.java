package com.scit.MakeBoard.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId==null) {
			response.sendRedirect(request.getContextPath()+"/login"); // request.getContextPath() 웹어플리케이션 프로젝트명을 가져온다.
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
}
