package com.cust.useCase;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.cust.entities.Address;
import com.cust.entities.Customer;
import com.cust.utility.EMUtil;

public class RegisterCustomer {

	public static void main(String[] args) {


		EntityManager em = EMUtil.provideEntityManager();
		
		List<Address> list1 = new ArrayList<>();
		list1.add(new Address("UP", "Delhi", "451278", "Home"));
		list1.add(new Address("Jh", "tata", "784541", "Work"));
		list1.add(new Address("TL", "HYD", "3784587", "Office"));
		
		Customer c = new Customer("Sonu", "78654851","sonu@gmail.com", list1);
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		
		em.close();

	}

}
