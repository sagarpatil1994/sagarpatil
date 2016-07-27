package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CartDAO;
import com.niit.shoppingcartbackend.model.Cart;

public class CartTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		CartDAO cartDAO= (CartDAO) context.getBean("cartDAO");
		Cart cart= (Cart) context.getBean("cart");
		
		cart.setId("CG122");
		cart.setName("GC121");
		cart.setDescription("CGDesc122");
		
		cartDAO.saveOrUpdate(cart);
	System.out.println("Record Inserted Successfully");
		
	}
}
