package com.colstu.entities;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.colstu.utility.EMUtil;

public class GetCollege {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Roll");
		
		int id = sc.nextInt();

		EntityManager em = EMUtil.provideEntityManager();
		
		Student s = em.find(Student.class, id);
		
		College c = s.getCollege();
		
		System.out.println("College Id is "+c.getCid());
		System.out.println("College Name is "+c.getCname());
		System.out.println("College Address is "+c.getCaddress());
		
		em.close();

	}

}
