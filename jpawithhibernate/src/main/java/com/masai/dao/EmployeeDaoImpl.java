package com.masai.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void save(Employee emp) {
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Employee Details Saved...");
		
		
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		
		String msg = "Wrong Employee ID";
		
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			msg = e.getAddress();
			
			em.getTransaction().commit();

		}
		
		em.close();
		
		return msg;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		
		String msg = "Wrong Employee ID";
		
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			e.setSalary(e.getSalary()+bonus);
			
			msg = bonus+"Bonus Added to employee ID"+empId+" in salary ";
			
			em.getTransaction().commit();

		}
		
		em.close();
		
		return msg;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			em.remove(e);
			
			em.getTransaction().commit();
			
			em.close();
			
			return true;
			
		}
		
		em.close();
		
		return false;
		
		
	}

}
