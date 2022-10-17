package com.usecase;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entities.Course;
import com.entities.Student;
import com.utility.EMUtil;

public class Demo3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student roll");
		
		int roll = sc.nextInt();
		
		EntityManager em  = EMUtil.provideEntityManager();
		
		Student s = em.find(Student.class, roll);
		
		List<Course> list = s.getCourses();
		
		System.out.println(list);
		
		em.close();

	}

}
