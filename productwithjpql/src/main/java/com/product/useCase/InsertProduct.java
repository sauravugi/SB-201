package com.product.useCase;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.product.EMUtility.EMUtility;
import com.product.entity.Product;

public class InsertProduct {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Product Name");
		String name = sc.next();
		System.out.println("Enter Product Quantity");
		int quan = sc.nextInt();
		System.out.println("Enter Product Price");
		int price = sc.nextInt();
		
		Product p = new Product(name, quan, price);
		
		EntityManager em = EMUtility.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Added");

	}

}
