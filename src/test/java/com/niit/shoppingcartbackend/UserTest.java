package com.niit.shoppingcartbackend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

public class UserTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		UserDAO userDAO= (UserDAO) context.getBean("userDAO");
		User user= (User) context.getBean("user");
		
		user.setId("CG122");
		user.setName("GC121");
		user.setPassword("********");
		user.setMobile(999999999);
		user.setEmail("priyanka.teli27@gmail.com");
		user.setAddress("Kalyan");
		
		userDAO.saveOrUpdate(user);
	System.out.println("Record Inserted Successfully");
		
	}
}
