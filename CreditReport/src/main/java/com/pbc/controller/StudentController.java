package com.pbc.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.dto.CreditReportDto;
import com.pbc.entity.CreditReport;
import com.pbc.entity.Student;
import com.pbc.entity.User;
import com.pbc.service.CreditReportingService;
import com.pbc.service.StudentService;
import com.pbc.service.UserService;
import com.pbc.utils.TrasferFile;

@Controller
public class StudentController {
	private static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	@Autowired
	CreditReportingService creditReportingService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/studentInfo" ,method = RequestMethod.POST)
	public ModelAndView addStudentCreditReport(
			Student s,
			CreditReportDto c,
			@RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage,
			HttpServletRequest request,
			String studentUserName)
	{
		
		User loginUser = (User) request.getSession().getAttribute("user");
		logger.info("[StudentController][addStudentCreditReport] loginUser="+loginUser.getUserName());
		if(StringUtils.isBlank(studentUserName))
		{
			if(loginUser.getRole().equals("manager"))
			{
				ModelAndView m = new ModelAndView("manager/studentFinishInfo");
				m.addObject("message", "请填写学生用户名");
				logger.info("[StudentController][addStudentCreditReport] role=manager,studentUserName="+studentUserName);
				return m;
			}
			else if(loginUser.getRole().equals("teacher"))
			{
				ModelAndView m = new ModelAndView("teacher/studentFinishInfo");
				m.addObject("message", "请填写学生用户名");
				logger.info("[StudentController][addStudentCreditReport] role=teacher,studentUserName="+studentUserName);
				return m;
			}
			else
			{
				logger.info("[StudentController][addStudentCreditReport] role=student,studentUserName="+studentUserName);
				return new ModelAndView("login");
			}
		}
		List<User> uList = userService.getUserByUserName(studentUserName);
		if(uList == null ||uList.isEmpty() || !uList.get(0).getRole().equals("student"))
		{
			if(loginUser.getRole().equals("manager"))
			{
				ModelAndView m = new ModelAndView("manager/studentFinishInfo");
				m.addObject("message", "此用户名不存在");
				logger.info("[StudentController][addStudentCreditReport] role=manager studentUserName="+studentUserName+" is not in database.");
				return m;
			}
			else if(loginUser.getRole().equals("teacher"))
			{
				ModelAndView m = new ModelAndView("teacher/studentFinishInfo");
				m.addObject("message", "此用户名不存在");
				logger.info("[StudentController][addStudentCreditReport] role=teacher studentUserName="+studentUserName+" is not in database.");
				
				return m;
			}
			else
			{
				ModelAndView m = new ModelAndView("login");
				logger.info("[StudentController][addStudentCreditReport] role=student studentUserName="+studentUserName+" is not in database.");
				return m;
			}
			
		}
		User u = uList.get(0);
		if(uploadImage != null && !uploadImage.isEmpty())
		{
			/*更新的时候先进行删除*/
			if(s != null && s.getUploadImageUrl() != null && !s.getUploadImageUrl().equals(""))
			{
				String path = request.getServletContext().getRealPath("/")+"UserImage";
				String sPath = path + s.getUploadImageUrl().substring(s.getUploadImageUrl().lastIndexOf("/")); 
				File file = new File(sPath);
				// 路径为文件且不为空则进行删除
				if (file.exists())
				{
					file.delete();
				}
			}
			String originalFile = uploadImage.getOriginalFilename();
			String newFileName = System.currentTimeMillis()+ originalFile.substring(originalFile.lastIndexOf("."));
			String savePath = "UserImage";
			String basePath = null;
			try {
				basePath = TrasferFile.saveFileImage(request, newFileName, uploadImage, savePath);
				s.setUploadImageUrl(basePath);
			}
			catch (Exception e)
			{
				e.printStackTrace() ;
				logger.debug("[StudentController][addStudentCreditReport]upload image error."+e);
			}
		}
		else
		{
			Student student = studentService.selectStudentById(u.getId());
			if(student != null && StringUtils.isNotBlank(student.getUploadImageUrl()))
			{
				s.setUploadImageUrl(student.getUploadImageUrl());
			}
		}
		s.setId(u.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		c.setStatus(1);
		if(StringUtils.isBlank(s.getCreateFileTime()))
		{
			Date now = new Date();
			String nowString = sdf.format(now);
			s.setCreateFileTime(nowString);
		}
		else
		{
			try {
				Date d = sdf.parse(s.getCreateFileTime());
				String nowString = sdf.format(d);
				s.setCreateFileTime(nowString);
			} catch (ParseException e) {
				logger.error("[StudentController][addStudentCreditReport]parse date error.",e);
			}
			
		}
		s.setStatus(1);
		c.setId(u.getId());
		studentService.insertOrUpdateCreditReport(s, c); 
		
		if(loginUser.getRole().equals("manager"))
		{
			ModelAndView m = new ModelAndView("manager/studentCreditReport");
			m.addObject("student", s);
			m.addObject("creditReport", c);
			logger.info("[StudentController][addStudentCreditReport] success.role=manager");
			
			return m;
		}
		else
		{
			ModelAndView m = new ModelAndView("teacher/studentCreditReport");
			m.addObject("student", s);
			m.addObject("creditReport", c);
			logger.info("[StudentController][addStudentCreditReport] success.role=teacher");
			return m;
		}
		
	} 
	
	@RequestMapping("/toStudentInfo")
	public ModelAndView toAddStudentCreditReport(HttpServletRequest request)
	{
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
		{
			logger.info("[StudentController][toAddStudentCreditReport] user == null.");
			return new ModelAndView("login");
		}
		if(user.getRole().equals("manager"))
		{
			logger.info("[StudentController][toAddStudentCreditReport] role == manager.");
			return new ModelAndView("manager/studentFinishInfo");
		}
		else if(user.getRole().equals("teacher"))
		{
			logger.info("[StudentController][toAddStudentCreditReport] role == teacher.");
			return new ModelAndView("teacher/studentFinishInfo");
		}
		else
		{
			logger.error("[StudentController][toAddStudentCreditReport] role == student.");
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/delCreditReport")
	public ModelAndView delCreditReport(
			HttpServletRequest request,
			@RequestParam(value="studentId") String studentId)
	{
		User user = (User)request.getSession().getAttribute("user");
		if(user == null )
		{
			logger.info("[StudentController][delCreditReport] user == null.");
			return new ModelAndView("login");
		}
		Map map = new HashMap();
		map.put("id", studentId);
		map.put("status", "0");
		
		creditReportingService.delCreditReportById(map);
		studentService.delStudentById(map);
		
		if(user.getRole().equals("manager"))
		{
			ModelAndView m = new ModelAndView();
			m.setViewName("manager/studentFinishInfo");
			logger.info("[StudentController][delCreditReport] del success.role=manager,userName="+user.getUserName()+",studentId="+studentId);
			return m;
		}
		else if(user.getRole().equals("teacher"))
		{
			ModelAndView m = new ModelAndView();
			m.setViewName("student/studentFinishInfo");
			logger.info("[StudentController][delCreditReport] del success.role=teacher,userName="+user.getUserName()+",studentId="+studentId);
			
			return m;
		}
		else
		{
			ModelAndView m = new ModelAndView();
			m.setViewName("login");
			logger.error("[StudentController][delCreditReport] del exception.role=student,userName="+user.getUserName()+",studentId="+studentId);
			
			return m;
		}
	}
	
	@RequestMapping("/modifyCreditReport")
	public ModelAndView modifyCreditReport(
			HttpServletRequest request,
			@RequestParam(value="studentId") Integer studentId)
	{
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser == null)
		{
			logger.info("[StudentController][modifyCreditReport] user == null");
			return new ModelAndView("login");
		}
		ModelAndView m = null;
		if(loginUser.getRole().equals("manager"))
		{
			m = new ModelAndView("manager/studentFinishInfo");
		}
		else if(loginUser.getRole().equals("teacher"))
		{
			m = new ModelAndView("teacher/studentFinishInfo");
		}
		else
		{
			m = new ModelAndView("login");
		}
		logger.info("[StudentController][modifyCreditReport] loginUserName="+loginUser.getUserName()+",role="+loginUser.getRole()+",studentId="+studentId);
		User user = userService.getUserById(studentId);
		Student s = studentService.selectStudentById(studentId);
		CreditReport cr = creditReportingService.selectCreditReportById(studentId);
		if(s == null && cr == null)
		{
			logger.error("[StudentController][modifyCreditReport] s == null,cr == null.loginUserName="+loginUser.getUserName()+",studentId="+studentId);
			return m;
		}
		CreditReportDto crDto = creditReportingService.CreditReportToCreditReportDto(cr);
		
		m.addObject("student", s);
		m.addObject("creditReport", crDto);
		m.addObject("studentUserName", user.getUserName());
		logger.info("[StudentController][modifyCreditReport] success to modify page.loginUserName="+loginUser.getUserName()+",studentId="+studentId);
		return m;
	}
	
	@RequestMapping("watchCreditReport")
	public ModelAndView toWatchCreditReport(HttpServletRequest request)
	{
		User u = (User)request.getSession().getAttribute("user");
		if(u == null)
		{
			logger.error("[StudentController][toWatchCreditReport] session is null.");
			return new ModelAndView("login");
		}
		if(u.getRole().equals("manager"))
		{
			logger.error("[StudentController][toWatchCreditReport] role=manager.loginUserName="+u.getUserName());
			return new ModelAndView("manager/studentWatchCreditReport");
		}
		else if(u.getRole().equals("student"))
		{
			logger.error("[StudentController][toWatchCreditReport] role=teacher.loginUserName="+u.getUserName());
			ModelAndView m = new ModelAndView("student/studentWatchCreditReport");
			Student s = studentService.selectStudentById(u.getId());
			CreditReport cr = creditReportingService.selectCreditReportById(u.getId());
			CreditReportDto crDto = creditReportingService.CreditReportToCreditReportDto(cr);
			m.addObject("student", s);
			m.addObject("creditReport", crDto);
			m.addObject("studentUserName", u.getUserName());
			return m;
		}
		else
		{
			logger.error("[StudentController][toWatchCreditReport] role=student.loginUserName="+u.getUserName());
			return new ModelAndView("teacher/studentWatchCreditReport");
		}
	}
	
	@RequestMapping("searchCreditReport")
	public ModelAndView searchCreditReport(
			@RequestParam(value="idCard") String idCard,
			@RequestParam(value="realName") String realName,
			@RequestParam(value="studentNumber") String studentNumber,
			HttpServletRequest request
			)
	{
		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser == null)
		{
			logger.error("[StudentController][searchCreditReport] loginUser == null.");
			return new ModelAndView("login");
		}
		Map map = new HashMap();
		if(StringUtils.isNotBlank(idCard))
		{
			map.put("idCard", idCard);	
		}
		if(StringUtils.isNotBlank(realName))
		{
			map.put("realName", realName);
		}
		if(StringUtils.isNotBlank(studentNumber))
		{
			map.put("studentNumber", studentNumber);
		}
		Student s = null;
		List<Student> sList = studentService.getStudentByMap(map);
		if(!sList.isEmpty())
		{
			s = sList.get(0);
		}
		CreditReport cr = null;
		if(s != null)
		{
			cr = creditReportingService.selectCreditReportById(s.getId());
		}
		CreditReportDto crDto = creditReportingService.CreditReportToCreditReportDto(cr);
		ModelAndView m = new ModelAndView();
		if(loginUser.getRole().equals("manager"))
		{
			m.addObject("student", s);
			m.addObject("creditReport", crDto);
			m.setViewName("manager/studentWatchCreditReport");
			logger.info("[StudentController][searchCreditReport] success. loginUserName="+loginUser.getUserName()+",role=manager");
			
			return m;
		}
		else if(loginUser.getRole().equals("teacher"))
		{
			m.addObject("student", s);
			m.addObject("creditReport", crDto);
			m.setViewName("teacher/studentWatchCreditReport");
			logger.info("[StudentController][searchCreditReport] success. loginUserName="+loginUser.getUserName()+",role=teacher");
			
			return m;
		}
		else
		{
			logger.info("[StudentController][searchCreditReport] success. loginUserName="+loginUser.getUserName()+",role=student");
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="toStudentPersonInfo")
	public ModelAndView toStudentPersonInfo(HttpServletRequest request)
	{
		User user = (User)request.getSession().getAttribute("user");
		Student s = studentService.selectStudentById(user.getId());
		ModelAndView modelAndView = new ModelAndView("student/studentFinishInfo");
		modelAndView.addObject("student", s);
		return modelAndView;
	}
	
	@RequestMapping(value="addOrUpdateStudent")
	public ModelAndView addorUpdateStudent(
			Student s,
			HttpServletRequest request,
			@RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage
			)
	{
		User loginUser = (User) request.getSession().getAttribute("user");
		if(loginUser == null)
		{
			return new ModelAndView("login");
		}
		if(uploadImage != null && !uploadImage.isEmpty())
		{
			/*更新的时候先进行删除*/
			if(s != null && s.getUploadImageUrl() != null && !s.getUploadImageUrl().equals(""))
			{
				String path = request.getServletContext().getRealPath("/")+"UserImage";
				String sPath = path + s.getUploadImageUrl().substring(s.getUploadImageUrl().lastIndexOf("/")); 
				File file = new File(sPath);
				// 路径为文件且不为空则进行删除
				if (file.exists())
				{
					file.delete();
				}
			}
			String originalFile = uploadImage.getOriginalFilename();
			String newFileName = System.currentTimeMillis()+ originalFile.substring(originalFile.lastIndexOf("."));
			String savePath = "UserImage";
			String basePath = null;
			try {
				basePath = TrasferFile.saveFileImage(request, newFileName, uploadImage, savePath);
				s.setUploadImageUrl(basePath);
			}
			catch (Exception e)
			{
				e.printStackTrace() ;
				logger.debug("[StudentController][addorUpdateStudent]upload image error."+e);
			}
		}
		else
		{
			Student student = studentService.selectStudentById(loginUser.getId());
			if(student != null && StringUtils.isNotBlank(student.getUploadImageUrl()))
			{
				s.setUploadImageUrl(student.getUploadImageUrl());
			}
		}
		s.setId(loginUser.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(StringUtils.isBlank(s.getCreateFileTime()))
		{
			Date now = new Date();
			String nowString = sdf.format(now);
			s.setCreateFileTime(nowString);
		}
		else
		{
			try {
				Date d = sdf.parse(s.getCreateFileTime());
				String nowString = sdf.format(d);
				s.setCreateFileTime(nowString);
			} catch (ParseException e) {
				logger.error("[StudentController][addorUpdateStudent]parse date error.",e);
			}
			
		}
		s.setStatus(1);
		studentService.insertStudent(s); 
		
		
		ModelAndView m = new ModelAndView("student/studentFinishInfoResult");
		m.addObject("student", s);
		return m;
		
	}
	@RequestMapping("modifyStudentInfo")
	public ModelAndView modifyStudentInfo(@RequestParam(value="studentId")Integer studentId)
	{
		Student s = studentService.selectStudentById(studentId);
		ModelAndView m = new ModelAndView("student/studentFinishInfo");
		m.addObject("student", s);
		return m;
	}
	
	@RequestMapping("detailedUserById")
	public ModelAndView detailedInfo(@RequestParam(value="userId")Integer userId)
	{
		User user = userService.getUserById(userId);
		if(user == null)
		{
			logger.info("[StudentController][detailedInfo] user is null.");
		}
		ModelAndView m = new ModelAndView("teacher/studentWatchCreditReportInfo");
		Student s = studentService.selectStudentById(user.getId());
		CreditReport cr = creditReportingService.selectCreditReportById(user.getId());
		CreditReportDto crDto = creditReportingService.CreditReportToCreditReportDto(cr);
		m.addObject("student", s);
		m.addObject("creditReport", crDto);
		m.addObject("studentUserName", user.getUserName());
		return m;
	}
}
