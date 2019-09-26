package cn.kgc.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.kgc.dao.UserDao;
import cn.kgc.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext-dao.xml"})
public class UserDaoTest {
	@Resource
	private UserDao userDao;
	
	@Test
	public void testSelectAll() {
		List<User> us = userDao.selectAll();
		for(User u:us){
			System.out.println(u);
		}
	}

	@Test
	public void testSelectById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectLikeName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddIntoUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateFromUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelFromUser() {
		fail("Not yet implemented");
	}

}
