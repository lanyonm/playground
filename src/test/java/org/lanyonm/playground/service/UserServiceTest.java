package org.lanyonm.playground.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanyonm.playground.config.DataConfig;
import org.lanyonm.playground.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={DataConfig.class, UserServiceImpl.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		assertNotNull("users should not be null", users);
	}

	@Test
	public void testSaveUser() {
		assertEquals("should have 1 user in the db", 1, userService.getAllUsers().size());
		User user = new User();
		user.setFirstName("Toby");
		user.setLastName("Cat");
		boolean ret = userService.saveUser(user);
		assertTrue("should have saved Toby", ret);
		user = userService.getAllUsers().get(1);
		assertEquals("number of users should now be 2", 2, userService.getAllUsers().size());
		assertTrue("Toby should now have an id", user.getFirstName().equals("Toby") && user.getId() > 0);
		user.setFirstName("Neko");
		userService.saveUser(user);
		assertEquals("number of users should still be 2", 2, userService.getAllUsers().size());
		assertEquals("the second user should be Neko", "Neko", userService.getAllUsers().get(1).getFirstName());
	}
}
