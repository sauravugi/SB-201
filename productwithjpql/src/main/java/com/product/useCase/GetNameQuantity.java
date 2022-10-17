package com.product.useCase;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.product.EMUtility.EMUtility;

public class GetNameQuantity {

	public static void main(String[] args) {

		EntityManager em= EMUtility.provideEntityManager();
		
		
		Query q= em.createNamedQuery("product.Name_Quantity");
		
		List<Object[]> results= q.getResultList();
		 
	 	for(Object[] or: results) {
	 		
	 		 String name= (String)or[0];
	 		 int balance= (Integer)or[1];
	 		
	 		 System.out.println("Product Name is "+name);
	 		 System.out.println("Product Quantity is :"+balance);
	 		 
	 		System.out.println("===========================");
	 	}
	 	

	 	em.close();
	}

}
