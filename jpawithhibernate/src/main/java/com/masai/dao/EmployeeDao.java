package com.masai.dao;

import com.masai.entities.Employee;

public interface EmployeeDao {
	
	void save(Employee emp);
	
	String getAddressOfEmployee(int empId);
	
	String giveBonusToEmployee(int empId, int bonus);
	
	boolean deleteEmployee(int empId);

}
