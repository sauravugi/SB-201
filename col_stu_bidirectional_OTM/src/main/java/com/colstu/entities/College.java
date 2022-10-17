package com.colstu.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String caddress;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "college")
	private List<Student> students = new ArrayList<>();
	
	public College() {
		// TODO Auto-generated constructor stub
	}

	public College(int cid, String cname, String caddress, List<Student> students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.caddress = caddress;
		this.students = students;
	}

	public College(String cname, String caddress, List<Student> students) {
		super();
		this.cname = cname;
		this.caddress = caddress;
		this.students = students;
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

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", students=" + students + "]";
	}
	
	

}
