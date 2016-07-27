package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Cart;

public interface CartDAO{
	public List<Cart> list();
	public Cart get(String id);
	public void saveOrUpdate(Cart cart);
	public void delete(String id);
	
}