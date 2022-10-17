package com.empl.dao;

import com.empl.entities.Employee;
import com.empl.exception.EmployeeException;

public interface EmployeDao {
	
	public Employee registerEmployee(Employee employee)throws EmployeeException;
	
	public Employee getEmployeeById(int empId)throws EmployeeException;
	
	public Employee deleteEmployeeById(int empId) throws EmployeeException;
	
	public Employee updateEmployee(Employee employee)throws EmployeeException;


}
