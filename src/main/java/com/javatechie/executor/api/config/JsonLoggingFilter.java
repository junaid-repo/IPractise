package com.javatechie.executor.api.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class JsonLoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			byte[] inputStreamBytes = StreamUtils.copyToByteArray(request.getInputStream());
			Map<String, String> jsonRequest = new ObjectMapper().readValue(inputStreamBytes, Map.class);

			String requestBodyJsonString = jsonRequest.get("body");
			System.out.println(requestBodyJsonString);
			System.out.println(response.getContentType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
