package com.empl.useCases;

import java.util.Scanner;

import com.empl.dao.EmployeDao;
import com.empl.dao.EmployeeDaoImpl;
import com.empl.entities.Employee;
import com.empl.exception.EmployeeException;

public class RegisterEmployee {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name ");
		String n = sc.next();
		
		System.out.println("Enter Address ");
		String a = sc.next();
		
		System.out.println("Enter Salary ");
		int s = sc.nextInt();
				
		
		Employee e = new Employee(n,a,s);
		
		EmployeDao dao = new EmployeeDaoImpl();
		Employee emp;
		try {
			emp = dao.registerEmployee(e);
			System.out.println(emp);
		} catch (EmployeeException e1) {
			
			e1.printStackTrace();
		}
		
		

	}

}
