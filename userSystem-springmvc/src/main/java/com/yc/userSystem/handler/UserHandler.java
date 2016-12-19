package com.yc.userSystem.handler;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yc.userSystem.bean.PaginationBean;
import com.yc.userSystem.bean.UserBean;
import com.yc.userSystem.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserHandler {
	
	@Autowired
	private  UserService userService;
	
	@RequestMapping("/login")
	public String dologin(UserBean user , HttpSession session ){
		LogManager.getLogger().debug("请求User login处理...");
		UserBean usered =  userService.userLogin(user) ;
		LogManager.getLogger().debug("请求处理的user是" + usered);
		if(usered != null ){
			//user 传过来直接就在request中，所以，只需要把作用域提升到session中就好..，不过我这里是页面跳转，就没有了
			session.setAttribute("user", usered);
			return "redirect:/easyui_page/user_edit.jsp";
		}
		
		session.setAttribute("errorMsg", "您输入的用户名或者密码有误！！");
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public PaginationBean<UserBean> listUser(String page , String rows){
		LogManager.getLogger().debug("请求User list处理...");
		PaginationBean<UserBean> pb = new PaginationBean<UserBean>();
		if(page!=null){
			pb.setPage(Integer.parseInt(page));
		}
		if(rows != null){
			pb.setPageSize(Integer.parseInt(rows));
		}
		pb = userService.list(pb);
		return pb;
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public boolean modifyUser(UserBean user , HttpServletRequest request ,MultipartFile picpathFile){
		LogManager.getLogger().debug("请求User modify处理...");
		LogManager.getLogger().debug("请求修改的user为 :"+user);
		
       if(userService.doUpload(picpathFile,request,user)){
    	  if( userService.modifyUser(user) ){
    		  return true;
    	  }
       }
        return false;
	} 
	
}
