package com.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.db.DB;
import com.model.Teacher;
import java.sql.Statement;

public class TeacherServiceImpl implements TeacherService{

	@Override
	public boolean register(Teacher teacher) {
		String query = "INSERT INTO teachers(firstName,lastName,userName,email,dob,password)VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = DB.getDBConnection().prepareStatement(query);
			pstm.setString(1, teacher.getFirstName());
			pstm.setString(2, teacher.getLastName());
			pstm.setString(3, teacher.getUserName());
			pstm.setString(4, teacher.getEmail());
			pstm.setDate(5, new Date(teacher.getDob().getTime()));
			pstm.setString(6,teacher.getPassword());
			
			pstm.execute();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean login(String userName, String password) {
		String query = String.format("SELECT * from teachers WHERE userName='%s' and password='%s'",userName,password);
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
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

}
