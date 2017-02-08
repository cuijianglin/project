package com.pbc.service;

import java.util.List;
import java.util.Map;

import com.pbc.entity.Manager;
import com.pbc.entity.User;

public interface UserService {
	void insertManagerInfo(Manager manager);
	void insertUser(User user);
	List<User> getUserList(Map map);
	int getUserCount();
	
	User getUserById(Integer userId);
	
	void updateUser(User user);
	void deleteUserById(Map map);
	
	List<User> getUserByUserName(String userName);
}
