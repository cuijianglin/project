package com.pbc.dao;

import java.util.List;
import java.util.Map;

import com.pbc.entity.Student;

public interface StudentDao {
	void insertStudent(Student s);
	public Student selectStudentById(Integer id);
	void delStudentById(Map map);
	List<Student> getStudentByMap(Map map);
}
