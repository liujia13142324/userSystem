package com.yc.userSystem.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.userSystem.bean.PaginationBean;
import com.yc.userSystem.bean.UserBean;
import com.yc.userSystem.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceImplTest {
	@Autowired
	private UserService userService;
	@Test
	public void testUserLogin() {
		UserBean u = new UserBean();
		u.setId(1003);
		u.setName("gIYSutLzoWOhtyjzUbxi");
		assertEquals(true,userService.userLogin(u));
	}
	
	@Test
	public void testUserList() {
		PaginationBean<UserBean> pb = new PaginationBean<UserBean>(11,20);
		pb = userService.list(pb);
		System.out.println(pb.getRows());
		assertNotNull(pb.getRows());
	}

}
