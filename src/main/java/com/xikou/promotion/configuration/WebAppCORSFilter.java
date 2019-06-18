package com.xikou.promotion.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebAppCORSFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(WebAppCORSFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, //
		FilterChain chain) throws ServletException {

		try {
			request.setCharacterEncoding("UTF-8");
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.setHeader("Access-Control-Allow-Origin", "*");
			servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
			servletResponse.setHeader("Access-Control-Max-Age", "3600");
			servletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
			chain.doFilter(request, response);
		} catch (IOException e) {
			logger.error("IO或者网络异常: " + e);
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}