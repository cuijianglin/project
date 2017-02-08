package com.pbc.dao;

import java.util.List;
import java.util.Map;

import com.pbc.entity.User;

public interface UserDao {
	void insertUser(User user);
	List<User> getUserList(Map map);
	int getUserCount();
	User getUserById(Integer userId);
	void updateUser(User user);
	void deleteUserById(Map map);
	List<User> getUserByUserName(String userName);
}
