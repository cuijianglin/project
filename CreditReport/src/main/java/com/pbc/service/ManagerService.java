package com.pbc.service;

import java.util.List;
import java.util.Map;

import com.pbc.entity.Manager;

public interface ManagerService {
	List<Manager> selectManagerInfo(Map<String, Object> map);
	int getCountManager();
	Manager selectById(Integer id);
	void deleteManagerById(Map map);
	
	void updateManager(Manager m);
}
