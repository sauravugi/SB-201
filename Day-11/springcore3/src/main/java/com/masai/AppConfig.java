package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {
	
	
	@Bean
	List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Ram",852));
		students.add(new Student(2,"Ranu",652));
		students.add(new Student(3,"Saurav",752));
		students.add(new Student(4,"Princy",552));
		students.add(new Student(5,"Sonu",952));
		return students;
	}

	
	
	@Bean
	List<String> getCities(){
		List<String> cities = new ArrayList<>();
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Kolkatta");
		cities.add("Chennai");
		cities.add("Lahore");
		
		return cities;
	
	}

	

	
}
