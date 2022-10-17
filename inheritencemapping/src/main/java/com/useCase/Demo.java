package com.useCase;

import javax.persistence.EntityManager;

import com.entities.Address;
import com.entities.Employee;
import com.utility.EMUtil;

public class Demo {

	public static void main(String[] args) {
		
		Address home1 = new Address("Bihar", "Siwan", "841232") ;
		Address home2 = new Address("Jharkhand", "Tata", "87454232") ;
		Address home3 = new Address("UP", "GZB", "02132") ;
		Address home4 = new Address("WB", "Kolkatta", "033232") ;
		
		Address office1 = new Address("TL", "hydrabad", "78432") ;
		Address office2 = new Address("KAR", "banglore", "154232") ;
		Address office3 = new Address("TN", "chennai", "955132") ;
		Address office4 = new Address("MAH", "pune", "7465632") ;
		
		Employee e1 = new Employee(home1, office1, 85000);
		e1.setName("Saurav");
		
		
		Employee e2 = new Employee(home2, office2, 95000);
		e2.setName("Sonu");
		
		Employee e3 = new Employee(home3, office3, 75000);
		e3.setName("Princy");
		
		Employee e4 = new Employee(home4, office4, 45000);
		e4.setName("Mukesh");
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done");

	}

}
