package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Student;
import com.masai.exception.StudentException;
import com.masai.utility.DBConnection;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void insertStudentData(Student stu) {

		try(Connection conn = DBConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, stu.getRoll());
			ps.setString(2,stu.getName());
			ps.setInt(3, stu.getMarks());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Student Added Sucessfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public Student showDetails(int roll) throws StudentException {
		
		Student student=null;
		
		try(Connection conn = DBConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");
			ps.setInt(1, roll);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int R = rs.getInt("roll");
				String N = rs.getString("name");
				int M = rs.getInt("marks");
				
				student = new Student(R,N,M);
				
			}else {
				throw new StudentException("Student Not Found");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

}
