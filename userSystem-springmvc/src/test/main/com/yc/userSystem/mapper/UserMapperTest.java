package com.yc.userSystem.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.userSystem.bean.PaginationBean;
import com.yc.userSystem.bean.UserBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserMapperTest {
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testFindUser() {
		UserBean u = new UserBean();
		u.setId(10001);
		u.setName("JLEOhtvXAMfrtSktnmsf");
		System.out.println(userMapper.findUser(u));
	}

	@Test
	public void testSelectById() {
		System.out.println(userMapper.selectById(10001));
	}

	@Test
	public void testGetAllUser() {
		System.out.println(userMapper.getAllUser());
	}

	@Test
	public void testUpdateUser() {
	}

	@Test
	public void testGetUserByPagination() {
		PaginationBean<UserBean> p = new PaginationBean<>();


		System.out.println(userMapper.getUserByPagination(p));
		
	}

}
