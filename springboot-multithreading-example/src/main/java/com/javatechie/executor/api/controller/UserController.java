package com.javatechie.executor.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javatechie.executor.api.dto.UsersList;
import com.javatechie.executor.api.entity.User;
import com.javatechie.executor.api.service.UserService;
import com.javatechie.executor.vo.ClassDTO;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value = "/users", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
		for (MultipartFile file : files) {
			service.saveUsers(file);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("aysnc/users/save")
	public ResponseEntity<CompletableFuture<String>> saveListOfUsers(@RequestBody UsersList usersList) {

		CompletableFuture<String> response = service.saveListOfUsers(usersList.getUsersList());

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@GetMapping(value = "/users", produces = "application/json")
	public CompletableFuture<ResponseEntity> findAllUsers() {
		return service.findAllUsers().thenApply(ResponseEntity::ok);
	}

	@GetMapping(value = "/getUsersByThread", produces = "application/json")
	public ResponseEntity getUsers() {
		CompletableFuture<List<User>> users1 = service.findAllUsers();
		CompletableFuture<List<User>> users2 = service.findAllUsers();
		CompletableFuture<List<User>> users3 = service.findAllUsers();
		CompletableFuture.allOf(users1, users2, users3).join();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PostMapping("/save/std")
	public ResponseEntity<CompletableFuture<String>> saveTeacher(@RequestBody List<ClassDTO> req) {
		CompletableFuture<String> response = service.saveTeachersDetails(req);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
