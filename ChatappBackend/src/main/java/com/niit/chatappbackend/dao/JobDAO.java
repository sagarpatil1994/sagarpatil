package com.niit.chatappbackend.dao;

import java.util.List;

import com.niit.chatappbackend.model.Job;

public interface JobDAO {
	
	public List<Job> list();
	public Job get(String id);
    public void saveOrUpdate(Job job);
    public void delete(String id);
}
