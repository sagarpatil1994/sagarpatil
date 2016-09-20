package com.niit.chatappbackend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chatappbackend.config.ApplicationContextConfig;
import com.niit.chatappbackend.dao.UserDAO;
import com.niit.chatappbackend.model.User;

public class UserTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		UserDAO userDAO= (UserDAO) context.getBean("userDAO");
		User user= (User) context.getBean("user");
		
		user.setId("104");
		user.setName("amita");
		user.setPassword("amita");
		user.setMobile(986478322);
		user.setEmail("amita@gmail.com");
		user.setAddress("Mumbai");
		
		
		userDAO.saveOrUpdate(user);
	System.out.println("Record Inserted Successfully");
		
	}
}
