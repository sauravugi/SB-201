package com.product.useCase;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.product.EMUtility.EMUtility;
import com.product.entity.Product;

public class GetPrice {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		
		EntityManager em= EMUtility.provideEntityManager();
		
		
		Query q= em.createNamedQuery("product.getPrice");
		
		q.setParameter("id", id);
		
		int n= (int)q.getSingleResult();
		 
		System.out.println("Price is "+n); 
		
		
		em.close();

	}

}
