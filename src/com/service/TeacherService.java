package com.service;

import java.util.List;

import com.model.Teacher;

public interface TeacherService {
	boolean register(Teacher teacher);
	boolean login(String userName,String password);
	List<Teacher> getAllTeacher();
	
}
