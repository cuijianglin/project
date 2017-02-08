package com.pbc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.entity.Manager;
import com.pbc.entity.User;
import com.pbc.service.ManagerService;

@Controller
public class ManagerController {
	private static Logger logger = Logger.getLogger(ManagerController.class);
	
	@Autowired
	ManagerService managerService;
	
	@RequestMapping("toShowManagerInfo")
	 public ModelAndView toShowManagerInfo(
			 @RequestParam(value="userName",required=false) String userName,
			 @RequestParam(value="realName",required=false) String realName,
			 @RequestParam(value="workUnit",required=false) String workUnit,
			 @RequestParam(value="pageIndex",required=false) Integer pageIndex
			 )
	 {
		logger.info("[ManagerController][toShowManagerInfo] userName="+userName+",realName="+realName+",workUnit="+workUnit+",pageIndex="+pageIndex);
		ModelAndView m = new ModelAndView("manager/managerList");
		Map<String, Object> map = new HashMap<String,Object>();
		if(!StringUtils.isBlank(userName))
		{
			map.put("userName", userName);
		}
		if(!StringUtils.isBlank(realName))
		{
			map.put("realName", realName);
		}
		if(!StringUtils.isBlank(workUnit))
		{
			map.put("workUnit", workUnit);
		}
		if(pageIndex == null)
		{
			pageIndex = 1;
		}
		int pageSize = 20;
		int recordPage = (pageIndex-1)*pageSize;
		
		map.put("pageIndex",recordPage );
		map.put("pageSize", pageSize);
		
		List<Manager> list = managerService.selectManagerInfo(map);
		int count = managerService.getCountManager();
		
		m.addObject("pageCount", count/pageSize+1);
		m.addObject("managerList", list);
		m.addObject("pageIndex", pageIndex);
		m.addObject("userName",userName);
		m.addObject("realName",realName);
		m.addObject("workUnit", workUnit);
		
		return m;
	 }
	
	@RequestMapping("delManagerById")
	public ModelAndView delManagerById(
			@RequestParam(value="managerId") Integer managerId,
			HttpServletRequest request
			)
	{
		User u = (User)request.getSession().getAttribute("user");
		logger.info("[ManagerController][delManagerById] managerId="+managerId+",loginUser="+u.getUserName());
		
		Map map = new HashMap();
		map.put("id", managerId);
		map.put("status", 0);
		managerService.deleteManagerById(map);
		return new ModelAndView("redirect:/toShowManagerInfo");
	}
	
	@RequestMapping("modifyManagerById")
	public ModelAndView modifyManagerById(@RequestParam(value="managerId") Integer managerId,
			HttpServletRequest request)
	{
		User u = (User)request.getSession().getAttribute("user");
		logger.info("[ManagerController][modifyManagerById] managerId="+managerId+",loginUser="+u.getUserName());
		
		ModelAndView modelAndView = new ModelAndView("/manager/updateManagerInfo");
		Manager m = managerService.selectById(managerId);
		modelAndView.addObject("id", m.getId());
		modelAndView.addObject("managerId", m.getManagerId());
		modelAndView.addObject("realName", m.getRealName());
		modelAndView.addObject("sex", m.getSex());
		modelAndView.addObject("workUnit", m.getUnitWork());
		return modelAndView;
	}
	
	@RequestMapping("updateManagerInfo")
	public ModelAndView updateManagerInfo(
			@RequestParam(value="id") Integer id,
			@RequestParam(value="managerId") String managerId,
			@RequestParam(value="realName") String realName,
			@RequestParam(value="sex") String sex,
			@RequestParam(value="workunit") String workunit,
			HttpServletRequest request
			)
	{
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			logger.error("[ManagerController][updateManagerInfo] session is null.");
			return new ModelAndView("login");
		}
		logger.info("[ManagerController][updateManagerInfo] id="+id+",managerId="+managerId+",loginUser="+user.getUserName()+",realName="+realName+",sex="+sex+",workunit="+workunit);
		
		Manager m = new Manager();
		m.setId(id);
		m.setRealName(realName);
		m.setSex(sex);
		m.setUnitWork(workunit);
	
		m.setUpdateTime(new Date());
		m.setUpdateUser(user.getUserName());
		m.setManagerId(managerId);
		
		managerService.updateManager(m);
		ModelAndView modelAndView = new ModelAndView("manager/managerList");
		return modelAndView;
	}
}
