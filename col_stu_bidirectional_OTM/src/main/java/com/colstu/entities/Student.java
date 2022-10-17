package com.colstu.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sroll;
	private String sname;
	private String mobile;
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private College college;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}


	public int getSroll() {
		return sroll;
	}

	public void setSroll(int sroll) {
		this.sroll = sroll;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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


	public Student(String sname, String mobile, String email, College college) {
		super();
		this.sname = sname;
		this.mobile = mobile;
		this.email = email;
		this.college = college;
	}


	public Student(int sroll, String sname, String mobile, String email, College college) {
		super();
		this.sroll = sroll;
		this.sname = sname;
		this.mobile = mobile;
		this.email = email;
		this.college = college;
	}


	@Override
	public String toString() {
		return "Student [sroll=" + sroll + ", sname=" + sname + ", mobile=" + mobile + ", email=" + email + ", college="
				+ college + "]";
	}

	
	
	

}
