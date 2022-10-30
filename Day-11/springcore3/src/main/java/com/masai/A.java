package com.masai;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class A {
	

	
	@Autowired
	List<Student> allStudents;
	
	@Autowired
	List<String> cities;
	
	@PostConstruct
	public void setUp() {
	System.out.println("inside set up method");
	}
	
	@PreDestroy
	public void tearDown(){
	System.out.println("inside tear down method");
	}
	
	
	void funA() {
		System.out.println("Inside A Class");
		for(Student s:allStudents) {
			System.out.println("Student Roll is : "+s.getRoll());
			System.out.println("Student Name is : "+s.getName());
			System.out.println("Student Marks is : "+s.getMarks());
			System.out.println("==========================");
		}
		
		//System.out.println(allStudents);
		
		System.out.println(cities.toString());
	}
	


	


}
