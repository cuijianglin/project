package com.pbc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pbc.dao.StudentDao;
import com.pbc.dto.CreditReportDto;
import com.pbc.entity.Student;
import com.pbc.service.CreditReportingService;
import com.pbc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	@Autowired
	CreditReportingService creditReportingService;
	@Override
	public void insertStudent(Student s) {
		studentDao.insertStudent(s);
	}

	@Override
	public Student selectStudentById(Integer id) {
		return studentDao.selectStudentById(id);
	}

	@Override
	public void delStudentById(Map map) {
		studentDao.delStudentById(map);
	}

	@Override
	@Transactional
	public void insertOrUpdateCreditReport(Student s, CreditReportDto crto) {
		insertStudent(s);
		creditReportingService.insertCreditReport(creditReportingService.CreditReportDtoToCreditReport(crto));
	}

	@Override
	public List<Student> getStudentByMap(Map map) {
		return studentDao.getStudentByMap(map);
	}
	
}
