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
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String duration;
	private int fee;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> students  = new ArrayList<>();
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String cname, String duration, int fee, List<Student> students) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.fee = fee;
		this.students = students;
	}

	public Course(int cid, String cname, String duration, int fee, List<Student> students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.fee = fee;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", fee=" + fee + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course(String cname, String duration, int fee) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.fee = fee;
	}
	
	
	

}
