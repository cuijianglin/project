package com.pbc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbc.dao.TeacherDao;
import com.pbc.entity.Teacher;
import com.pbc.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherDao teacherDao;
	
	@Override
	public void insertTeacher(Teacher t) {
		teacherDao.insertTeacher(t);
	}

	@Override
	public Teacher selectTeacherById(Integer id) {
		return teacherDao.selectTeacherById(id);
	}

	@Override
	public void delTeacherById(Map map) {
		teacherDao.delTeacherById(map);
	}

	@Override
	public List<Teacher> getTeacherByMap(Map map) {
		return teacherDao.getTeacherByMap(map);
	}

}
