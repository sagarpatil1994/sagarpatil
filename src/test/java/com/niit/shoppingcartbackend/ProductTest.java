package com.niit.shoppingcartbackend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.model.Product;

public class ProductTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		ProductDAO productDAO= (ProductDAO) context.getBean("productDAO");
		Product product= (Product) context.getBean("product");
		
		product.setId("P121");
		product.setName("P121");
		product.setDescription("PDesc121");
		product.setPrice(45000);
		
		productDAO.saveOrUpdate(product);
	System.out.println("Record Inserted Successfully");
		
	}
}
