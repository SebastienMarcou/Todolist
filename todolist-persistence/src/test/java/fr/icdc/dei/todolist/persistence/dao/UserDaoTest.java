package fr.icdc.dei.todolist.persistence.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.User;
import fr.icdc.dei.todolist.persistence.entity.UserFree;

public class UserDaoTest extends AbstractDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	private static final User user = new UserFree();

	@Test
	public void testCreateUser() {
		assertNotNull(userDao.save(user));
	}

}
