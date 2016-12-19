package com.yc.userSystem.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.yc.userSystem.bean.PaginationBean;
import com.yc.userSystem.bean.UserBean;

public interface UserService {

	UserBean userLogin(UserBean user);

	PaginationBean<UserBean> list(PaginationBean<UserBean> p);

	boolean modifyUser(UserBean user);

	boolean doUpload(MultipartFile picpathFile, HttpServletRequest request,UserBean user);

}
