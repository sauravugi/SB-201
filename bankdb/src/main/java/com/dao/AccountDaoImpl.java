package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Account;



public class AccountDaoImpl implements AccountDao{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");

	@Override
	public Account findById(int id) {
		
		Account a  = null;
		
		EntityManager em = emf.createEntityManager();
		
		Account e = em.find(Account.class, id);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			a=e;
			
			em.getTransaction().commit();

		}
		
		em.close();
		
		return a;
	}

	@Override
	public String save(Account account) {
		String msg ="Not Saved";
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		em.close();
		
		msg = "Employee Details Saved...";
		
		return msg;
	}

	@Override
	public String deleteAccountById(int id) {
		
		String msg = "Not Deleted";
		
		EntityManager em = emf.createEntityManager();
		
		Account e = em.find(Account.class, id);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			em.remove(e);
			
			em.getTransaction().commit();
			
			em.close();
			
			msg = "deleted succesfully";
			
		}
		
		em.close();
		
		return msg;
	}

	@Override
	public String deposit(double amount, int accountId) {
		
		String msg = "Wrong Account ID";
		
		EntityManager em = emf.createEntityManager();
		
		Account e = em.find(Account.class, accountId);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			e.setBalance(e.getBalance()+amount);
			
			msg = amount+"  Added to employee ID "+accountId+" in salary ";
			
			em.getTransaction().commit();

		}
		
		em.close();
		
		return msg;
	}

	@Override
	public String withdraw(double amount, int accountId) {
		String msg = "Wrong Account ID";
		
		EntityManager em = emf.createEntityManager();
		
		Account e = em.find(Account.class, accountId);
		
		if(e!=null) {
			
			em.getTransaction().begin();
			
			e.setBalance(e.getBalance()-amount);
			
			msg = amount+"  deposite to employee ID "+accountId+" in salary ";
			
			em.getTransaction().commit();

		}
		
		em.close();
		
		return msg;
	}

}
