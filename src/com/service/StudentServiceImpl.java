package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Student;

public class StudentServiceImpl implements StudentService{

	@Override
	public boolean register(Student student) {
		String query = "INSERT INTO students(firstName,lastName,userName,password)VALUES(?,?,?,?)";
		try {
			PreparedStatement pstm = DB.getDBConnection().prepareCall(query);
			pstm.setString(1, student.getFirstName());
			pstm.setString(2, student.getLastName());
			pstm.setString(3, student.getUserName());
			pstm.setString(4, student.getPassword());
			
			pstm.execute();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String userName, String password) {
		String query = String.format("SELECT * FROM students WHERE userName='%s' and password='%s'",userName,password);
		try {
			Statement stm = DB.getDBConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Student student) {
		String getDataQuery = String.format("SELECT * from students WHERE userName='%s'",student.getUserName());
		
	
		String firstName = student.getFirstName();
		String lastName= student.getLastName();
		String password = student.getPassword();
		
		
		try {
			Statement stm = DB.getDBConnection().createStatement();
			ResultSet rs = stm.executeQuery(getDataQuery);
			System.out.println("inside try");
			
			if(rs.next()) {
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(password);
				if(firstName == null)
					firstName = rs.getString("firstName");
				if(lastName == null)
					lastName = rs.getString("lastName");
				if(password == null)
					password = rs.getString("password");
				String updateQuery = String.format("UPDATE students SET firstName ='%s',lastName='%s',password='%s' WHERE userName='%s'",firstName,lastName,password,student.getUserName());
				stm.executeUpdate(updateQuery);
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public List<Student> getAllStudent() {
		String query = "SELECT * FROM students";
		List<Student> students = new ArrayList<Student>();
		try {
			Statement stm = DB.getDBConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			Student student;
			while(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setUserName(rs.getString("userName"));
				students.add(student);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getStudentByUserName(String userName) {
		
		return null;
	}

	@Override
	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> searchStudent(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
