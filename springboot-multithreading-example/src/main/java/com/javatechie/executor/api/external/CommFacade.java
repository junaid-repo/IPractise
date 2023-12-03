package com.javatechie.executor.api.external;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.javatechie.executor.vo.ClassDTO;

@Component
public class CommFacade {

	@Autowired
	RestTemplate restTemplate;

	public String callCreateTeacher(ClassDTO req) {

		//HttpEntity<ClassDTO> request = new HttpEntity<>(req, httpHeaders());
		

		String url = "http://localhost:4007/school/save/class";

		String response = restTemplate.postForObject(url, req, String.class);

		return response;
	}

	private Object httpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		return httpHeaders;
	}

}