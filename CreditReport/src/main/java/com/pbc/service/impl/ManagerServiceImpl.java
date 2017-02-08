package com.pbc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbc.dao.ManagerDao;
import com.pbc.entity.Manager;
import com.pbc.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	ManagerDao managerDao;
	
	@Override
	public List<Manager> selectManagerInfo(Map<String, Object> map) {
		return managerDao.selectManagerList(map);
	}

	@Override
	public int getCountManager() {
		return managerDao.getCountManager();
	}

	@Override
	public Manager selectById(Integer id) {
		return managerDao.selectById(id);
	}

	@Override
	public void deleteManagerById(Map map) {
		managerDao.deleteManagerById(map);
	}

	@Override
	public void updateManager(Manager m) {
		managerDao.updateManager(m);
	}

}
