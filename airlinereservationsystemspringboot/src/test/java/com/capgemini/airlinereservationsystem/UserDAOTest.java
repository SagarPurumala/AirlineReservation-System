package com.capgemini.airlinereservationsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.airlinereservationsystem.beans.UserBean;
import com.capgemini.airlinereservationsystem.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
	
	@Autowired
	//@Qualifier("dao")
	private UserDAO dao;
	
	//@Ignore
	@Test
	public void registerTest() {
		UserBean userBean = new UserBean();
		userBean.setUserFirstName("Sandeep");
		userBean.setUserLastName("Tiwari");
		userBean.setUserEmail("admin@gmail.com");
		userBean.setUserContact(9582848408l);
		userBean.setUserId("sandy123");
		userBean.setUserPassword("sandy123");
		userBean.setUserRole("admin");
		//dao.registerByAdmin(userBean);
		assertEquals(true, dao.registerByAdmin(userBean));
	}
	
//	@Test
//	public void userLoginTest() {
//		String actual = dao.userLogin("Sandy1", "sandy12345");
//		assertEquals("user", actual);
//	}
//	
//	@Test
//	public void adminLoginTest1() {
//		String actual = dao.userLogin("admin1", "Admin@123");
//		assertEquals("admin", actual);
//	}
	
//	@Test
//	public void executiveLoginTest1() {
//		String actual = dao.userLogin("Ashu", "acer12");
//		assertEquals("exe", actual);
//	}

}
