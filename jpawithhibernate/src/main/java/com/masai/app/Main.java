package com.masai.app;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.entities.Employee;

public class Main {

	public static void main(String[] args) {

		EmployeeDao ed = new EmployeeDaoImpl();
		
		while(true) {
			System.out.println("1. Save Employee Data in Database");
			System.out.println("2. Get Address of Employee");
			System.out.println("3. Give Bonus to Employee");
			System.out.println("4. Delete Employee Data in Database");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choice");
			Scanner sc = new Scanner(System.in);
			int c = sc.nextInt();
			
			if(c==1) {
				
				System.out.println("Enter Employee Id");
				int empid = sc.nextInt();
				
				System.out.println("Enter Employee Name");
				String name = sc.next();

				System.out.println("Enter Employee Address");
				String address = sc.next();
				
				System.out.println("Enter Employee salary");
				int salary = sc.nextInt();
				
				Employee e = new Employee(empid, name, address, salary);
				
				ed.save(e);
				
			}else if(c==2) {
				
				System.out.println("Enter Employee Id");
				int empid = sc.nextInt();
				
				String msg = ed.getAddressOfEmployee(empid);
				
				System.out.println(msg);
				
			}else if(c==3) {
				
				System.out.println("Enter Employee Id");
				int empid = sc.nextInt();
				
				System.out.println("Enter Employee Bonus");
				int bonus = sc.nextInt();
				
				String msg = ed.giveBonusToEmployee(empid,bonus);
				
				System.out.println(msg);
				
			}else if(c==4) {
				
				System.out.println("Enter Employee Id");
				int empid = sc.nextInt();
				
				boolean flag = ed.deleteEmployee(empid);
				
				if(flag==true) System.out.println("Employee data deleted..");
				else System.out.println("Wrong employee Id or Record not found");
				
			}else {
				break;
			}
		
		}

		

	}

}
