package com.usecase;

import javax.persistence.EntityManager;

import com.entities.Course;
import com.entities.Student;
import com.utility.EMUtil;

public class Demo1 {

	public static void main(String[] args) {

		Student s1  = new Student("Saurav", "7854121", "saurav@gmail.com");
		Student s2  = new Student("Sonu", "4551521", "sonu@gmail.com");
		Student s3  = new Student("ravi", "7154521", "ravi@gmail.com");
		Student s4  = new Student("ram", "1245421", "ram@gmail.com");
		Student s5  = new Student("raushan", "7845121", "raushan@gmail.com");
		
		
		Course c1 = new Course("Java", "6 months", 80000);
		Course c2 = new Course("Hibernate", "3 months", 60000);
		Course c3 = new Course("Spring", "4 months", 40000);
		Course c4 = new Course("Sql", "2 months", 30000);
		
		c1.getStudents().add(s5);   // Bind Value Course to Student
		c1.getStudents().add(s3);
		c1.getStudents().add(s1);
		c2.getStudents().add(s2);
		c2.getStudents().add(s3);
		c3.getStudents().add(s1);
		c3.getStudents().add(s2);
		c3.getStudents().add(s4);
		c4.getStudents().add(s4);
		c4.getStudents().add(s5);
		
		s1.getCourses().add(c1);   //Bind value student to course 
		s1.getCourses().add(c3);
		s2.getCourses().add(c2);
		s2.getCourses().add(c3);
		s3.getCourses().add(c1);
		s3.getCourses().add(c2);
		s4.getCourses().add(c4);
		s4.getCourses().add(c3);
		s5.getCourses().add(c4);
		s5.getCourses().add(c1);
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done");
		

	}

}
