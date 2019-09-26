package cn.kgc.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.kgc.entity.User;
import cn.kgc.service.Public_transportationService;
import cn.kgc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext-*.xml"})
public class UserServiceTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void testAddIntoUser() {
		User user=new User();
		user.setPassword("123");
		user.setUserName("Smith");
		userService.addIntoUser(user);
		System.out.println("init");
	}

	@Test
	public void testUpdateFromUser() {
		System.out.println("123");
	}

	@Test
	public void testDelFromUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByUserName() {
		User user = userService.queryByUserName("admin");
		System.out.println(user);
	}

	@Test
	public void testQueryRoles() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryPermissions() {
		fail("Not yet implemented");
	}

}
