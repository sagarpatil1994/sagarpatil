package com.niit.chatappbackend.dao;

import java.util.List;

import com.niit.chatappbackend.model.Blog;

public interface BlogDAO {
	
	public List<Blog> list();
	public Blog get(String id);
    public void saveOrUpdate(Blog blog);
    public void delete(String id);
}
