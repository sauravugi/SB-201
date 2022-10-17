package com.colstu.entities;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.colstu.utility.EMUtil;

public class GetStudent {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter College");
		
		int id = sc.nextInt();

		EntityManager em = EMUtil.provideEntityManager();
		
		College s = em.find(College.class, id);
		
		List<Student> list = s.getStudents();
		
		for(Student st:list) {
			System.out.println("Student ID "+st.getSroll());
			System.out.println("Student Name "+st.getSname());
			System.out.println("Student Mobile "+st.getMobile());
			System.out.println("Student Email "+st.getEmail());
			System.out.println("=====================================");
		}
		
		em.close();


	}

}
