package com.pbc.dao;

import java.util.List;
import java.util.Map;

import com.pbc.entity.Teacher;

public interface TeacherDao {
	void insertTeacher(Teacher t);
	Teacher selectTeacherById(Integer id);
	void delTeacherById(Map map);
	List<Teacher> getTeacherByMap(Map map);
}
