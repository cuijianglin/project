package com.pbc.service;

import java.util.List;
import java.util.Map;

import com.pbc.entity.Teacher;

public interface TeacherService {
	void insertTeacher(Teacher t);
	Teacher selectTeacherById(Integer id);
	void delTeacherById(Map map);
	List<Teacher> getTeacherByMap(Map map);
}
