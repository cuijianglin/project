
package com.pbc.dao;

import java.util.List;
import java.util.Map;

import com.pbc.entity.User;

public interface LoginDao {
	User getUserInfoById(Integer id);
	List<User> getUserInfoByUserName(Map map);
	int updateUser(User u);
}
