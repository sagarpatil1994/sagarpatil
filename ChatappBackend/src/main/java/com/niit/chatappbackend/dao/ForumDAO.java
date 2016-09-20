package com.niit.chatappbackend.dao;

import java.util.List;

import com.niit.chatappbackend.model.Forum;

public interface ForumDAO {
	
	public List<Forum> list();
	public Forum get(String id);
    public void saveOrUpdate(Forum forum);
    public void delete(String id);
}
