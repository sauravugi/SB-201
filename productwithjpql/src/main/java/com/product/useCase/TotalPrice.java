package com.product.useCase;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.product.EMUtility.EMUtility;
import com.product.entity.Product;

public class TotalPrice {

	public static void main(String[] args) {


		EntityManager em= EMUtility.provideEntityManager();
		
		String jpql = "select sum(price) from Product";
		
		Query q= em.createQuery(jpql);
		
		Long p = (Long)q.getSingleResult();
		
		System.out.println("Total Price of Products "+p);
		
		em.close();

	}

}
