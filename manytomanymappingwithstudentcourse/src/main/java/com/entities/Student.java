package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roll;
	private String name;
	private String mobile;
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "students")
	List<Course> courses  = new ArrayList<>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(String name, String mobile, String email, List<Course> courses) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.courses = courses;
	}

	public Student(int roll, String name, String mobile, String email, List<Course> courses) {
		super();
		this.roll = roll;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", mobile=" + mobile + ", email=" + email + "]";
	}

	public Student(String name, String mobile, String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
	
	

}
