package com.javatechie.executor.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.executor.api.dto.UsersList;
import com.javatechie.executor.api.entity.User;
import com.javatechie.executor.api.service.SimpleUserService;

@RestController
@RequestMapping("/simple")
public class SimpleController {

	@Autowired
	SimpleUserService sserv;

	@PostMapping("/users/save")
	ResponseEntity<String> saveUser(@RequestBody UsersList usersList) {

		String response = sserv.saveUsers(usersList.getUsersList());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
