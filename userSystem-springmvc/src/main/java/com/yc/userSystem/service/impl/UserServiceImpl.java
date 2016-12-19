package com.yc.userSystem.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yc.userSystem.bean.PaginationBean;
import com.yc.userSystem.bean.UserBean;
import com.yc.userSystem.mapper.UserMapper;
import com.yc.userSystem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserBean userLogin(UserBean user) {
		return userMapper.findUser(user) ;
	}

	@Override
	public PaginationBean<UserBean> list(PaginationBean<UserBean> p) {
		return userMapper.getUserByPagination(p);
	}

	@Override
	public boolean modifyUser(UserBean user) {
		return userMapper.updateUser(user) > 0;
	}

	@Override
	public boolean doUpload(MultipartFile picpathFile ,HttpServletRequest request,UserBean user) {
		String path = request.getServletContext().getRealPath("")+"/upload/"+picpathFile.getOriginalFilename();
		String workpath="D:\\workspaces2\\userSystem-springmvc\\src\\main\\webapp\\upload\\"+picpathFile.getOriginalFilename();
		LogManager.getLogger().debug("服务器上传文件地址为："+path);
		
		//这种只能移动一次，但文件流到服务器下面时候，就没有东西流到工作目录下面了...
		FileOutputStream fout =null;
		InputStream in = null;
		if(!picpathFile.isEmpty()){
			try {
				in = picpathFile.getInputStream();
				picpathFile.transferTo(new File(path));
				File file = new File(workpath);
				if(!file.exists()){
					file.createNewFile();
					fout  = new FileOutputStream(file);
					byte[] bs = new byte[1024];
					for(;in.read(bs)!=-1;){
						fout.write(bs);
					}
					fout.flush();
				}
				
				user.setPicpath("upload/"+picpathFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				return false;
			}finally{
				try {
					if(fout!=null){
						fout.close();
					}
					if(in!=null){
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
}
