package com.niit.chatappbackend.dao;

import java.util.List;

import com.niit.chatappbackend.model.Chat;

public interface ChatDAO {
	
	public List<Chat> list();
	public Chat get(String id);
    public void saveOrUpdate(Chat chat);
    public void delete(String id);
}
