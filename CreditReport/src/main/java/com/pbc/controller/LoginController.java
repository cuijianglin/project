package com.pbc.controller;

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

import com.pbc.entity.User;
import com.pbc.service.LoginService;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/signin")
	public ModelAndView signin()
	{
		ModelAndView m = new ModelAndView("login");
		return m;
	}
	@RequestMapping("/login")
	public ModelAndView login(
			@RequestParam(value="userName",required=false) String userName,
			@RequestParam(value="password",required=false) String password,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		logger.info("[LoginController][login] param:userName:"+userName+",password:"+password);
		//参数有问题的时候直接跳转到登录页面
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password))
		{
			ModelAndView m = new ModelAndView("login");
			m.addObject("message", "请输入用户名或密码");
			logger.info("[LoginController][login] userName or password is null.userName="+userName+",password="+password);
			return m;
		}
	
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", userName);
		List<User> userList = loginService.getUserInfoByUserName(map);
		if(userList == null || userList.isEmpty())
		{
			ModelAndView m = new ModelAndView("login");
			m.addObject("message","该用户名不存在");
			logger.info("[LoginController][login] userName is not in database.userName="+userName);
			return m;
		}
		User user = userList.get(0);
		ModelAndView m = null;
		String md5Password = loginService.getUserMD5Password(password, user);
		if(md5Password.equals(user.getPassword()))
		{	
			request.getSession().setAttribute("user", user);
			if(user.getRole().equals("teacher"))
			{
				m = new ModelAndView("/teacher/setPassword");
				m.addObject("userName", user.getUserName());
			}
			else if(user.getRole().equals("manager"))
			{
				m = new ModelAndView("/manager/setPassword");	
				m.addObject("userName", user.getUserName());
			}
			else
			{
				m = new ModelAndView("/student/setPassword");
				m.addObject("userName", user.getUserName());
			}
		}
		else
		{
			m = new ModelAndView("login");
			m.addObject("message", "用户名或密码错误");
			logger.info("[LoginController][login] password is error.userName="+userName+",password="+password);
		}
		
		return m;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		ModelAndView m = new ModelAndView("login");
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			return m;
		}
		logger.info("[LoginController][logout] logout.userName="+user.getUserName());
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		
		return m;
	}
}
