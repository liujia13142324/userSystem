package com.yc.userSystem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;

@WebFilter("/*")
public class UserCheckFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		String projectName = req.getContextPath();
		if(uri.endsWith("user_edit.jsp")){
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("user");
			LogManager.getLogger().debug("检验的用户为:"+obj);
			if(obj == null){
				session.setAttribute("errorMsg", "用户未登陆！");
				((HttpServletResponse) response).sendRedirect(projectName+"/login.jsp");
			}else{
				chain.doFilter(request, response);	
			}
		}
		chain.doFilter(request, response);	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		LogManager.getLogger().debug("初始化用户检验的过滤处理UserCheckFilter....");
	}

}
