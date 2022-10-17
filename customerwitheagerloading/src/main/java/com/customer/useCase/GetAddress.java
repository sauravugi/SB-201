package com.customer.useCase;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.customer.entities.Address;
import com.customer.entities.Customer;
import com.customer.utility.EMUtil;

public class GetAddress {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Id");

		int id = sc.nextInt();

		EntityManager em = EMUtil.provideEntityManager();
		
		String jpql = "from Customer where cid =:id";
		
		Query q = em.createQuery(jpql);
		
		q.setParameter("id", id);
		
		Customer c = (Customer)q.getSingleResult();
		
		em.close();
		
		List<Address> list = c.getAddresses();
		
		list.forEach(a->System.out.println(a));
		
		

	}

}
