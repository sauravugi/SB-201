package com.empl.useCases;

import java.util.Scanner;

import com.empl.dao.EmployeDao;
import com.empl.dao.EmployeeDaoImpl;
import com.empl.entities.Employee;
import com.empl.exception.EmployeeException;

public class DeleteEmployeeById {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id ");
		int i = sc.nextInt();
		
		EmployeDao dao = new EmployeeDaoImpl();
		Employee emp;
		try {
			emp = dao.deleteEmployeeById(i);
			System.out.println(emp);
		} catch (EmployeeException e1) {
			
			e1.printStackTrace();
		}

	}

}
