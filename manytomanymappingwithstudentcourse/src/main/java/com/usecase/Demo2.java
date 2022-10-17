package com.usecase;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entities.Course;
import com.entities.Student;
import com.utility.EMUtil;

public class Demo2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Id");
		
		int id = sc.nextInt();
		
		EntityManager em  = EMUtil.provideEntityManager();
		
		Course s = em.find(Course.class, id);
		
		List<Student> list = s.getStudents();
		
		System.out.println(list);
		
		em.close();

	}

}
