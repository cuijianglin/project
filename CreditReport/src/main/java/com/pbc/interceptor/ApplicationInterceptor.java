package com.pbc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.entity.User;


public class ApplicationInterceptor implements HandlerInterceptor{
	private static Logger LOGGER = Logger.getLogger(ApplicationInterceptor.class);
	private List<String> uncheckUrls; 
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		String requestUrl = request.getRequestURI(); 
		for (String url : this.getUncheckUrls()) {
			if(requestUrl.contains(url)){
				//LOGGER.debug("@@@@@@@@@@@@@@@"+requestUrl+"@@@@@@@@@@@@@@@@@@-> pass");
				return true;
			}
		}
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {//
			LOGGER.warn("session timeout");
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":"+request.getServerPort()+path + "/signin";
			 response.sendRedirect(basePath);  
			 return false;
		} else {
			 return true;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public List<String> getUncheckUrls() {
		return uncheckUrls;
	}

	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}
}
