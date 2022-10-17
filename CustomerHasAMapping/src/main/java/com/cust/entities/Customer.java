package com.cust.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String name;
	
	private String mobile;
	
	private String email;
	
	@ElementCollection
	@Embedded
	@JoinTable(name = "cust_adr",joinColumns =@JoinColumn(name = "cust_Id"))
	List<Address> addresses = new ArrayList<>();

	public Customer(int cid, String name, String mobile, String email, List<Address> addresses) {
		super();
		this.cid = cid;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.addresses = addresses;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", addresses="
				+ addresses + "]";
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String mobile, String email, List<Address> addresses) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.addresses = addresses;
	}
	
	

}
