package com.pbc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbc.dao.ManagerDao;
import com.pbc.dao.UserDao;
import com.pbc.entity.Manager;
import com.pbc.entity.User;
import com.pbc.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	ManagerDao managerDao;
	@Autowired
	UserDao userDao;
	@Override
	public void insertManagerInfo(Manager manager) {
		managerDao.insertManagerInfo(manager);
	}
	@Override
	public void insertUser(com.pbc.entity.User user) {
		userDao.insertUser(user);
	}
	@Override
	public List<User> getUserList(Map map) {
		return userDao.getUserList(map);
	}
	@Override
	public int getUserCount() {
		return userDao.getUserCount();
	}
	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	@Override
	public void deleteUserById(Map map) {
		userDao.deleteUserById(map);
	}
	@Override
	public List<User> getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

}
