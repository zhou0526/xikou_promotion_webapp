package com.xikou.promotion.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BusinessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, //
		HttpServletResponse httpServletResponse, Object handler) throws Exception {

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, //
		HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, //
		HttpServletResponse response, Object handler) throws Exception {
	}

}
