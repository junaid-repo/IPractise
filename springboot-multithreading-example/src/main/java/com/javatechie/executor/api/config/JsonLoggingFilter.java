package com.javatechie.executor.api.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JsonLoggingFilter implements Filter {

	/*
	 * @Override public void init(FilterConfig filterConfig) throws ServletException
	 * {
	 * 
	 * }
	 * 
	 * @Override public void destroy() {
	 * 
	 * }
	 */

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
				(HttpServletResponse) response);

		try {
			chain.doFilter(requestWrapper, responseWrapper);
		} finally {

			String requestBody = new String(requestWrapper.getContentAsByteArray());
			String responseBody = new String(responseWrapper.getContentAsByteArray());
			// Do not forget this line after reading response content or actual response
			// will be empty!
			responseWrapper.copyBodyToResponse();
			System.out.println(requestBody);
			System.out.println("The response body is-->" + responseBody);

			// Write request and response body, headers, timestamps etc. to log files

		}

	}

}
