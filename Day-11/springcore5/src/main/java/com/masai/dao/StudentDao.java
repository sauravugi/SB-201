package com.masai.dao;

import com.masai.bean.Student;
import com.masai.exception.StudentException;

public interface StudentDao {
	
	void insertStudentData(Student stu);
	
	Student showDetails(int roll) throws StudentException;

}
