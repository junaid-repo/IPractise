package com.javatechie.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.jpa.dto.ClassDTO;
import com.javatechie.jpa.entity.ClassEntity;
import com.javatechie.jpa.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	SchoolService serv;

	@PostMapping("/save/class")
	ResponseEntity<String> saveClassDetails(@RequestBody ClassDTO request) {

		String response = serv.saveTeacher(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}
	@GetMapping("/get/class/{std}")
	ResponseEntity<ClassEntity> getClassDetails(@PathVariable Integer std){
		ClassEntity response = new ClassEntity();
		
		response=serv.getClassDetails(std);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}

}
