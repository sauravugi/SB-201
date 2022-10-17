package com.empl.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.empl.entities.Employee;
import com.empl.exception.EmployeeException;
import com.empl.utility.EMUtil;

public class EmployeeDaoImpl implements EmployeDao{

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		
		if(employee.getName()==null || employee.getAddress()==null || employee.getSalary()==0)
			throw new EmployeeException("Not Proper details of Employee");
		else {

		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(employee);
		
		em.getTransaction().commit();
		
		em.close();
		
		EntityManager em1 = EMUtil.provideEntityManager();
		
		String jpql = "from Employee where name =:nm and address = :ad and salary = :sl";
		
		
		
		Query td = em1.createQuery(jpql);
		
		td.setParameter("nm", employee.getName());
		td.setParameter("ad", employee.getAddress());
		td.setParameter("sl", employee.getSalary());
		
		Employee e = (Employee)td.getSingleResult();
		
		return e;
		}
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e==null) throw new EmployeeException("Employee not found");
		
		else return e;
		
	}

	@Override
	public Employee deleteEmployeeById(int empId) throws EmployeeException {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e==null) throw new EmployeeException("Employee not found");
		
		else {
			em.getTransaction().begin();
			
			em.remove(e);
			
			em.getTransaction().commit();
		}
			
		em.close();

		return e;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee e = em.find(Employee.class, employee.getEmpId());
		
		if(e==null) throw new EmployeeException("Employee not found");
		
		else {
			em.getTransaction().begin();
			
			em.merge(employee);
			
			em.getTransaction().commit();
		}
			
		em.close();

		return e;
	}

}
