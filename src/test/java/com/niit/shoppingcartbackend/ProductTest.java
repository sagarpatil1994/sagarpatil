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
		
		product.setId("SUP121");
		product.setName("SUPName121");
		product.setDescription("Mobile");
		product.setPrice(10000);
		
		productDAO.saveOrUpdate(product);
	System.out.println("successfully record inserted");
	
	
	System.out.println("No of Product" + productDAO.list().size());
		
	}
}
