package com.pbc.dao;

import java.util.List;
import java.util.Map;

import com.pbc.entity.Manager;

public interface ManagerDao {
	void insertManagerInfo(Manager manager);
	List<Manager> selectManagerList(Map<String, Object> map);
	int getCountManager();
	Manager selectById(Integer id);
	void deleteManagerById(Map map);
	void updateManager(Manager m);
}
