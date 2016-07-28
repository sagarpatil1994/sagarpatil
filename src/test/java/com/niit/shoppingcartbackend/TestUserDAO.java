package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

public class TestUserDAO {
@Autowired
UserDAO userDAO;
@Autowired
User user;
AnnotationConfigApplicationContext context;
@Before
public void init()
{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	userDAO=(UserDAO) context.getBean("userDAO");
	user=(User) context.getBean("user");
	
}
@Test
public void UsersTestCase()
{
	int size=userDAO.list().size();
	assertEquals("User list test case",1,size);
}
}