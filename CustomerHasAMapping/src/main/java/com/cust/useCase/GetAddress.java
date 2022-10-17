package com.cust.useCase;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cust.entities.Address;
import com.cust.entities.Customer;
import com.cust.utility.EMUtil;

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
		
		List<Address> list = c.getAddresses();
		
		list.forEach(a->System.out.println(a));
		
		em.close();

	}

}
