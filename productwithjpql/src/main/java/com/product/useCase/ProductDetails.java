package com.product.useCase;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.product.EMUtility.EMUtility;
import com.product.entity.Product;

public class ProductDetails {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		
		EntityManager em= EMUtility.provideEntityManager();
		
		String jpql = "from Product where pid = :id";
		
		Query q= em.createQuery(jpql);
		
		q.setParameter("id", id);
		
		Product p = (Product)q.getSingleResult();
		
		System.out.println(p);
		
		em.close();

	}

}
