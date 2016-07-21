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
		
		user.setId("SUP121");
		user.setName("sam");
		user.setAddress("Dom");
		user.setPassword("sam101");
		user.setMail("ABC");
		user.setMobileno(649656484);
		
		userDAO.saveOrUpdate(user);
	System.out.println("successfully record inserted");
	
	
	System.out.println("No of user" + userDAO.list().size());
		
	}
}
