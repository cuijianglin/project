package com.pbc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbc.controller.LoginController;
import com.pbc.dao.LoginDao;
import com.pbc.entity.User;
import com.pbc.service.LoginService;
import com.pbc.utils.MD5Util;

@Service
public class LoginServiceImpl implements LoginService{

	private static Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	@Autowired
	LoginDao loginDao;
	@Override
	public User getUserInfoById(Integer id) {
		return loginDao.getUserInfoById(id);
	}
	@Override
	public List<User> getUserInfoByUserName(Map map) {
		return loginDao.getUserInfoByUserName(map);
	}
	@Override
	public String getUserMD5Password(String orgPassword,User user) {
		logger.info("[LoginServiceImpl][getUserMD5Password] param.orgPassword="+orgPassword+",userName="+user.getUserName());
		//密码生成方式：首先将密码和用户名进行一次md5加密，
		String md5Once = MD5Util.string2MD5(orgPassword);
		//密码生成方式：其次将第一次生成的密码和创建时间进行一次md5加密，创建时间格式是2016-12-12
		//密码生成方式：最后取前30位
		md5Once = md5Once.substring(0, md5Once.length()-2);
		logger.info("[LoginServiceImpl][getUserMD5Password] param.targetPassword="+md5Once+",userName="+user.getUserName());
		return md5Once;
	}
	@Override
	public int updateUser(User user) {
		loginDao.updateUser(user);
		return 0;
	}

}
