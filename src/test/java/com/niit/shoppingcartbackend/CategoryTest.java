package com.niit.shoppingcartbackend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.model.Category;

public class CategoryTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		Category category= (Category) context.getBean("category");
		
		category.setId("CG122");
		category.setName("GC121");
		category.setDescription("CGDesc122");
		categoryDAO.saveOrUpdate(category);
	System.out.println("Record Inserted Successfully");
		
	}
}
