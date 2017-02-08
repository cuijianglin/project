package com.pbc.service;

import java.util.List;
import java.util.Map;

import com.pbc.entity.User;

public interface LoginService {
	User getUserInfoById(Integer id);
	List<User> getUserInfoByUserName(Map map);
	
	String getUserMD5Password(String orgPassword,User user);
	
	int updateUser(User user);
}
