package com.product.useCase;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.product.EMUtility.EMUtility;
import com.product.entity.Product;

public class QuantityLessThanFive {

	public static void main(String[] args) {
		
		EntityManager em= EMUtility.provideEntityManager();
		
		String jpql = "from Product where quantity < 5";
		
		Query q= em.createQuery(jpql);
		
		List<Product> list = q.getResultList();
		
		list.forEach((p)->System.out.println(p));
		
		em.close();


	}

}
