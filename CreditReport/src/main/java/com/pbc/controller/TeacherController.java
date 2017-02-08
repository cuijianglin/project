package com.pbc.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.pbc.entity.Teacher;
import com.pbc.entity.User;
import com.pbc.service.TeacherService;
import com.pbc.service.UserService;
import com.pbc.utils.TrasferFile;

@Controller
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	UserService userService;
	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@RequestMapping("toTeacherInfo")
	public ModelAndView toTeacherInfo()
	{
		return new ModelAndView("manager/teacherCreditReport");
	}
	
	@RequestMapping("/delTeacher")
	public ModelAndView delTeacher(@RequestParam(value="teacherId") String teacherId)
	{
		Map map = new HashMap();
		map.put("id", teacherId);
		map.put("status", "0");
		teacherService.delTeacherById(map);
		
		ModelAndView m = new ModelAndView();
		m.setViewName("manager/teacherFinishInfo");
		return m;
	}
	
	@RequestMapping("modifyTeacher")
	public ModelAndView modifyTeacher(@RequestParam(value="teacherId") Integer teacherId)
	{
		User user = userService.getUserById(teacherId);
		Teacher s = teacherService.selectTeacherById(teacherId);
		if(s == null)
		{
			return new ModelAndView("manager/teacherFinishInfo");
		}
		ModelAndView m = new ModelAndView("manager/teacherFinishInfo");
		m.addObject("teacher", s);
		m.addObject("teacherUserName", user.getUserName());
		return m;
	}
	
	
	@RequestMapping("toAddTeacher")
	public ModelAndView toAddTeacher()
	{
		return new ModelAndView("manager/teacherFinishInfo");
	}
	
	@RequestMapping("addTeacher")
	public ModelAndView addTeacher(
			Teacher t,
			@RequestParam(value = "uploadImage", required = false) MultipartFile uploadImage,
			HttpServletRequest request,
			String teacherUserName)
	{
		if(StringUtils.isBlank(teacherUserName))
		{
			ModelAndView m = new ModelAndView("manager/teacherFinishInfo");
			m.addObject("message", "请填写教师用户名");
			return m;
		}
		List<User> uList = userService.getUserByUserName(teacherUserName);
		if(uList == null || uList.isEmpty() || !uList.get(0).getRole().equals("teacher"))
		{
			ModelAndView m = new ModelAndView("manager/teacherFinishInfo");
			m.addObject("message", "此用户名不存在");
			return m;
		}
		User u = uList.get(0);
		if(uploadImage != null && !uploadImage.isEmpty())
		{
			/*更新的时候先进行删除*/
			if(t != null && t.getUploadImageUrl() != null && !t.getUploadImageUrl().equals(""))
			{
				String path = request.getServletContext().getRealPath("/")+"UserImage";
				String sPath = path + t.getUploadImageUrl().substring(t.getUploadImageUrl().lastIndexOf("/")); 
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
				t.setUploadImageUrl(basePath);
			}
			catch (Exception e)
			{
				e.printStackTrace() ;
				logger.debug("[TeacherController][addTeacher]upload image error."+e);
			}
		}
		else
		{
			Teacher teacher = teacherService.selectTeacherById(u.getId());
			t.setUploadImageUrl(teacher.getUploadImageUrl());
		}
		t.setId(u.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		t.setStatus(1);
		if(StringUtils.isBlank(t.getCreateFileTime()))
		{
			Date now = new Date();
			String nowString = sdf.format(now);
			t.setCreateFileTime(nowString);
		}
		else
		{
			try {
				Date d = sdf.parse(t.getCreateFileTime());
				String nowString = sdf.format(d);
				t.setCreateFileTime(nowString);
			} catch (ParseException e) {
				logger.error("[TeacherController][addTeacher]parse date error.",e);
			}
			
		}
		teacherService.insertTeacher(t);
		ModelAndView m = new ModelAndView("manager/teacherCreditReport");
		m.addObject("teacher", t);
		m.addObject("teacherUserName", u.getUserName());
		return m;
	}
	
	
	@RequestMapping("searchTeacher")
	public ModelAndView searchTeacher(
			@RequestParam(value="idCard") String idCard,
			@RequestParam(value="realName") String realName,
			@RequestParam(value="teacherNumber") String teacherNumber
			)
	{
		Map map = new HashMap();
		if(StringUtils.isNotBlank(idCard))
		{
			map.put("idCard", idCard);	
		}
		if(StringUtils.isNotBlank(realName))
		{
			map.put("realName", realName);
		}
		if(StringUtils.isNotBlank(teacherNumber))
		{
			map.put("teacherNumber", teacherNumber);
		}
		Teacher s = null;
		List<Teacher> tList = teacherService.getTeacherByMap(map);
		if(!tList.isEmpty())
		{
			s = tList.get(0);
		}
		User user = userService.getUserById(s.getId());
		ModelAndView m = new ModelAndView();
		m.addObject("teacher", s);
		m.addObject("teacherUserName",user.getUserName());
		m.setViewName("manager/teacherWatchCreditReport");
		return m;
	}
	@RequestMapping("toSearchTeacher")
	public ModelAndView toSearchTeacher()
	{
		return new ModelAndView("manager/teacherWatchCreditReport");
	}
}
