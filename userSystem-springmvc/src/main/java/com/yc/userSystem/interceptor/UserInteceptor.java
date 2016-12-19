package com.yc.userSystem.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yc.userSystem.bean.UserBean;

public class UserInteceptor implements HandlerInterceptor {

	public UserInteceptor() {
		LogManager.getLogger().debug("修改用户拦截器初始化...");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LogManager.getLogger().debug("判断用户是否有足够的权限...");
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		if(user.getPrivige()!=null && user.getPrivige()>0){
			LogManager.getLogger().debug("用户权足够，可以进行修改...");
			return true;
		}
		LogManager.getLogger().debug("用户权限不够...");
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
