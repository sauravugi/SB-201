package com.customer.useCase;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.customer.entities.Address;
import com.customer.entities.Customer;
import com.customer.utility.EMUtil;

public class RegisterCustomer {

	public static void main(String[] args) {


		EntityManager em = EMUtil.provideEntityManager();
		
		List<Address> list1 = new ArrayList<>();
		list1.add(new Address("BR", "SIWAN", "451456451", "Home"));
		list1.add(new Address("WB", "KOL", "321564867", "Office"));
		
		Customer c = new Customer("Saurav", "7875451","saurav@gmail.com", list1);
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		
		em.close();

	}

}
