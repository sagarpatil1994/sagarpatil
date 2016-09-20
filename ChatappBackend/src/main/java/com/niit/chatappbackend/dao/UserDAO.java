package com.niit.chatappbackend.dao;

import java.util.List;

import com.niit.chatappbackend.model.User;

public interface UserDAO {
	
	public List<User> list();
	public User get(String id);
    public void saveOrUpdate(User user);
    public void delete(String id);
    public boolean isValidUser(String userID,String password);
}
