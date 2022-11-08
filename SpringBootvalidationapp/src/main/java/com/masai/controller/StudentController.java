package com.masai.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;

@RestController
public class StudentController {
	
	
	@PostMapping("/students")
	public ResponseEntity<String> registerStudent(@Valid @RequestBody Student student) {
		
		
		//we need to connect with SL + DAL to save supplied Student to the DB
		
		
		return new ResponseEntity<String>("Student Saved Successfully "+student.getName(), HttpStatus.CREATED);
		
		
	}
	
	

}
