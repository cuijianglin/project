package com.pbc.service;

import java.util.List;
import java.util.Map;

import com.pbc.dto.CreditReportDto;
import com.pbc.entity.Student;

public interface StudentService {
	void insertStudent(Student s);
	Student selectStudentById(Integer id);
	void delStudentById(Map map);
	
	void insertOrUpdateCreditReport(Student s,CreditReportDto crto);
	
	List<Student> getStudentByMap(Map map);
}
