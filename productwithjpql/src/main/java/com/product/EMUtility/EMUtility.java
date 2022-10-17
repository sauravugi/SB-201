package com.product.EMUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtility {
	
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("product-Unit");
	}
	
	public static EntityManager provideEntityManager() {
		
		return emf.createEntityManager();
	}

}
