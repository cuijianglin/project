package com.pbc.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public class TrasferFile {
	   public static  String saveFileImage(HttpServletRequest request,String newFileName, MultipartFile filedata,String savePath) throws IllegalStateException, IOException 
	   {
		   //	savePath = request.getServletContext().getRealPath("/")+savePath;
		   	String dirFile = request.getSession().getServletContext().getRealPath("/") +savePath;
		   	if(!new File(dirFile).exists())
		   	{
		   		new File(dirFile).mkdirs();
		   	}
	        //这里封装了读取配置文件的方法 配置文件中有图片的存放地址和获取地址
	        String filePath = request.getSession().getServletContext().getRealPath("/") +"/"+savePath+"/"+newFileName;
	        
	        filedata.transferTo(new File(filePath));
	        String path = request.getContextPath();
	        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+savePath+"/"+newFileName;
	        return basePath;
	   }
}
