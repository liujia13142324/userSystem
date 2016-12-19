package com.yc.userSystem.mapper;

import java.util.List;

import com.yc.userSystem.bean.PaginationBean;
import com.yc.userSystem.bean.UserBean;

public interface UserMapper {
	UserBean findUser(UserBean user);
	
	UserBean selectById(int id);

	List<UserBean> getAllUser();

	int updateUser(UserBean user);

	<T> PaginationBean<T> getUserByPagination(PaginationBean<UserBean> user);
}
