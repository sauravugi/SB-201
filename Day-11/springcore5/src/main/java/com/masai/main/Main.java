package com.masai.main;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class Main {

	public static void main(String[] args) {
		
		//Student s = new Student(12, "Sonu", 750);
		
		StudentDao dao = new StudentDaoImpl();
		
		//dao.insertStudentData(s);
		
		try {
			Student s = dao.showDetails(12);
			System.out.println(s);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
