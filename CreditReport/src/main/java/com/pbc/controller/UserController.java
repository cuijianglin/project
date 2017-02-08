package com.pbc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.entity.Manager;
import com.pbc.entity.User;
import com.pbc.service.LoginService;
import com.pbc.service.ManagerService;
import com.pbc.service.UserService;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	
	@Autowired
	ManagerService managerService;
	
	@RequestMapping("toSetPassword")
	public ModelAndView toSetPassword(HttpServletRequest request)
	{
		User u = (User)request.getSession().getAttribute("user");
		if(u == null)
		{
			logger.error("[UserController][toSetPassword] session is null.");
			return new ModelAndView("login");
		}
		if(u.getRole().equals("manager"))
		{
			ModelAndView m = new ModelAndView("manager/setPassword");
			m.addObject("userName", u.getUserName());
			return m;
		}
		else if(u.getRole().equals("student"))
		{
			ModelAndView m = new ModelAndView("student/setPassword");
			m.addObject("userName", u.getUserName());
			return m;
		}
		else
		{
			ModelAndView m = new ModelAndView("teacher/setPassword");
			m.addObject("userName", u.getUserName());
			return m;
		}
	}
	@RequestMapping("setPassword")
	public ModelAndView setPassword(
			@RequestParam(value="userName",required=false) String userName,
			@RequestParam(value="password",required=false) String password,
			HttpServletRequest request)
	{
		ModelAndView m = new ModelAndView();
		logger.info("[LoginController][setPassword] userName="+userName+",password="+password);
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			return new ModelAndView("login");
		}
		if(user.getRole().equals("student"))
		{
			m.setViewName("student/setPassword");
			userName = user.getUserName();
		}
		else if(user.getRole().equals("manager"))
		{
			m.setViewName("manager/setPassword");
		}
		else
		{
			m.setViewName("teacher/setPassword");
			userName = user.getUserName();
		}
	
		
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password))
		{
			m.addObject("message", "用户名或密码为空");
			return m;
		}
		try
		{
			Map<String,String> map = new HashMap<String,String>();
			map.put("userName", userName);
			List<User> uList = loginService.getUserInfoByUserName(map);
			if(uList == null || uList.isEmpty())
			{
				m.addObject("message", "用户不存在");
				return m;
			}
			User u = uList.get(0);
				
			String md5Password = loginService.getUserMD5Password(password, u);
			u.setPassword(md5Password);
			
			loginService.updateUser(u);
			m.addObject("message", "重置密码成功");
			m.addObject("userName",userName);
		}catch(Exception e)
		{
			logger.error("[LoginController][setPassword] error:",e);
			m.addObject("message", "重置密码失败");
			m.addObject("userName",userName);
		}
		return m;
	}
	@RequestMapping("toFinishInfo")
	public ModelAndView toFinishInfo(HttpServletRequest request)
	{
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			logger.error("[UserController][toFinishInfo] session is null.");
			return new ModelAndView("login");
		}
		//获取manager
		Manager manager = managerService.selectById(user.getId());
		if(manager == null)
		{
			return new ModelAndView("manager/finishInfo");
		}
		else
		{
			ModelAndView m = new ModelAndView("manager/finishInfo");
			m.addObject("managerId", manager.getManagerId());
			m.addObject("realName", manager.getRealName());
			m.addObject("workUnit", manager.getUnitWork());
			m.addObject("sex", manager.getSex());
			return m;
		}
	}
	
	/**
	 * 管理员完善信息
	 * @param realName
	 * @param sex
	 * @param workunit
	 * @return
	 */
	@RequestMapping("finishInfo")
	public ModelAndView finishInfo(
			@RequestParam(value="realName",required=false) String realName,
			@RequestParam(value="sex",required=false) String sex,
			@RequestParam(value="workunit",required=false) String workunit,
			@RequestParam(value="managerId",required=false) String managerId,
			HttpServletRequest request,
			HttpServletResponse response
			)
	{
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			logger.error("[UserController][finishInfo] session is null.");
			return new ModelAndView("login");
		}
		//验证user
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", user.getUserName());
		List<User> uList = loginService.getUserInfoByUserName(map);
		if(uList == null || uList.isEmpty())//在数据库中没有查找到当前的用户
		{
			logger.error("[UserController][finishInfo] no user exist in database.userName="+user.getUserName());
			return new ModelAndView("login");
		}
		User u = uList.get(0);
		Manager m = new Manager();
		m.setId(u.getId());
		m.setRealName(realName);
		m.setSex(sex);
		m.setUnitWork(workunit);
		m.setCreateTime(new Date());
		m.setCreateUser(user.getUserName());
		m.setUpdateTime(new Date());
		m.setUpdateUser(user.getUserName());
		m.setManagerId(managerId);
		m.setStatus(1);
		userService.insertManagerInfo(m);
		
		logger.info("[UserController][finishInfo] max id is :"+m.getId()+",userName="+user.getUserName());
		ModelAndView model = new ModelAndView("redirect:/toShowManagerInfo");
		
		return model;
	}
	
	@RequestMapping("addAccount")
	public ModelAndView addAccount(
			@RequestParam(value="userName",required=false) String userName,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="role",required=false) String role,
			HttpServletRequest request
			)
	{
		User u = (User)request.getSession().getAttribute("user");
		if(u == null)
		{
			logger.error("[UserController][addAccount] session is null.");
			return new ModelAndView("login");
		}
		if(u.getRole().equals("teacher"))
		{
			role = "student";
		}
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) || StringUtils.isBlank(role))
		{
			if(u.getRole().equals("manager"))
			{
				ModelAndView m = new ModelAndView("manager/addAccount");
				m.addObject("message", "用户名或密码为空");
				return m;
			}
			else if(u.getRole().equals("teacher"))
			{
				ModelAndView m = new ModelAndView("teacher/addAccount");
				m.addObject("message", "用户名或密码为空");
				return m;
			}
			else
			{
				return new ModelAndView("login");
			}
		}
		List<User> checkUser = userService.getUserByUserName(userName);
		if(checkUser != null && !checkUser.isEmpty())
		{
			if(u.getRole().equals("manager"))
			{
				ModelAndView m = new ModelAndView("manager/addAccount");
				m.addObject("message", "该用户已存在");
				return m;
			}
			else if(u.getRole().equals("teacher"))
			{
				ModelAndView m = new ModelAndView("teacher/addAccount");
				m.addObject("message", "该用户已存在");
				return m;
			}
			else
			{
				return new ModelAndView("login");
			}
		}
		
		User user = new User();
		user.setRole(role);
		user.setCreateTime(new Date());
		user.setCreateUser(u.getUserName());
		user.setUpdateUser(u.getUserName());
		user.setUpdateTime(new Date());
		user.setUserName(userName);
		user.setStatus(1);
		String md5Password = loginService.getUserMD5Password(password, user);
		user.setPassword(md5Password);
		
		userService.insertUser(user);
		
		ModelAndView m = null;
		
		if(u.getRole().equals("manager"))
		{
			m = new ModelAndView("manager/addAccount");
			m.addObject("message", "添加成功");
			return m;
		}
		else if(u.getRole().equals("teacher"))
		{
			m = new ModelAndView("teacher/addAccount");
			m.addObject("message", "添加成功");
			return m;
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("toAddAccount")
	public ModelAndView addAccount(HttpServletRequest request)
	{
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser == null)
		{
			return new ModelAndView("login");
		}
		if(loginUser.getRole().equals("manager"))
		{
			return new ModelAndView("manager/addAccount");
		}
		else if(loginUser.getRole().equals("teacher"))
		{
			return new ModelAndView("teacher/addAccount");
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("toAccountList")
	public ModelAndView toAccountList(
			@RequestParam(value="userName",required=false) String userName,
			@RequestParam(value="role",required=false) String role,
			Integer pageIndex,
			HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser == null)
		{
			return new ModelAndView("login");
		}
		if(loginUser.getRole().equals("manager"))
		{
			modelAndView = new ModelAndView("manager/accountList");
		}
		else if(loginUser.getRole().equals("teacher"))
		{
			modelAndView = new ModelAndView("teacher/accountList");
		}
		else
		{
			return new ModelAndView("login");
		}
		Integer pageSize = 20;
		if(pageIndex == null)
		{
			pageIndex = 1;
		}
		Map map = new HashMap();
		if(StringUtils.isNotBlank(userName))
		{
			map.put("userName", userName);
		}
		if(StringUtils.isNotBlank(role))
		{
			map.put("role", role);
		}
		
		if(loginUser.getRole().equals("teacher"))
		{
			map.put("role", "student");
		}
		Integer recordPage = (pageIndex-1) * pageSize;
		map.put("pageSize", pageSize);
		map.put("pageIndex", recordPage);
		
		List<User> list = userService.getUserList(map);
		int count = userService.getUserCount();
		modelAndView.addObject("userList", list);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageCount", count/pageSize+1);
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("role", role);
		return modelAndView;
	}
	
	@RequestMapping("delUserById")
	public ModelAndView delManagerById(@RequestParam(value="userId") Integer userId)
	{
		Map map = new HashMap();
		map.put("id", userId);
		map.put("status", 0);
		userService.deleteUserById(map);
		return new ModelAndView("redirect:/toAccountList");
	}
	@RequestMapping("modifyUserById")
	public ModelAndView modifyManagerById(
			@RequestParam(value="userId") Integer userId,
			HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser == null)
		{
			return new ModelAndView("login");
		}
		if(loginUser.getRole().equals("manager"))
		{
			modelAndView = new ModelAndView("manager/updateUserInfo");
		}
		else if(loginUser.getRole().equals("teacher"))
		{
			modelAndView = new ModelAndView("teacher/updateUserInfo");
		}
		else
		{
			return new ModelAndView("login");
		}
		User user = userService.getUserById(userId);
		modelAndView.addObject("id", user.getId());
		modelAndView.addObject("userName", user.getUserName());
		modelAndView.addObject("role", user.getRole());
		return modelAndView;
	}
	
	@RequestMapping("updateUserInfo")
	public ModelAndView updateUserInfo(
			@RequestParam(value="id") Integer id,
			@RequestParam(value="userName") String userName,
			@RequestParam(value="role",required=false) String role,
			HttpServletRequest request
			)
	{
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			logger.error("[UserController][updateUserInfo] session is null.");
			return new ModelAndView("login");
		}
		User m = new User();
		m.setId(id);
		m.setUserName(userName);
		m.setRole(role);
	
		m.setUpdateTime(new Date());
		m.setUpdateUser(user.getUserName());
		
		userService.updateUser(m);
		ModelAndView modelAndView = new ModelAndView("redirect:/toAccountList");
		
		return modelAndView;
	}
	

}
