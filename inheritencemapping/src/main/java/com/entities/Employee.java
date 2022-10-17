package com.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
@Entity
public class Employee extends Person{
	@Embedded
	@AttributeOverrides({
			
		@AttributeOverride(name="state" , column = @Column(name="Home_state")),
		@AttributeOverride(name="city" , column = @Column(name="Home_city")),
		@AttributeOverride(name="pincode" , column = @Column(name="Home_pincode")),
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		
		@AttributeOverride(name="state" , column = @Column(name="Office_state")),
		@AttributeOverride(name="city" , column = @Column(name="Office_city")),
		@AttributeOverride(name="pincode" , column = @Column(name="Office_pincode")),
	})
	private Address officeAddress;
	
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(Address homeAddress, Address officeAddress, int salary) {
		super();
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + ", salary=" + salary + "]";
	}
	
	

}
