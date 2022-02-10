package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	void register(Student student);
	boolean login(String userName,String password);
	List<Student> getAllStudent();
	Student getStudentByUserName(String userName);
	Student getStudentByID(int id);
	List<Student> searchStudent(String search);	
}
