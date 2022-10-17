package com.colstu.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.colstu.utility.EMUtil;

public class useCase1 {

	public static void main(String[] args) {
		
		College c1 = new College();
		College c2 = new College();
		
		List<Student> list1  = new ArrayList<>();
		List<Student> list2  = new ArrayList<>();
		
		list1.add(new Student("Saurav", "78454454", "saurav@gmail.com", c1));
		list1.add(new Student("Somya", "784518", "somya@gmail.com", c1));
		list1.add(new Student("Ritesh", "7845444545", "ritesh@gmail.com", c1));
		list1.add(new Student("Ram", "795224", "ram@gmail.com", c1));
		
		
		list2.add(new Student("Kavi", "54514454", "kavi@gmail.com", c2));
		list2.add(new Student("Ravi", "875454454", "ravi@gmail.com", c2));
		list2.add(new Student("Mukesh", "1544454", "mukesh@gmail.com", c2));
		list2.add(new Student("Sobhit", "8754454", "sobhit@gmail.com", c2));
		
		c1.setCname("UIET College");
		c1.setCaddress("Punjab");
		c1.setStudents(list1);
		
		c2.setCname("BSEB College");
		c2.setCaddress("Bihar");
		c2.setStudents(list2);
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.getTransaction().commit();
		
		em.close();
		
		

	}

}
