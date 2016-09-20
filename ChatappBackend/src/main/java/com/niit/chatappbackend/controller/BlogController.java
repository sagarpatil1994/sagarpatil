package com.niit.chatappbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chatappbackend.dao.BlogDAO;
import com.niit.chatappbackend.model.Blog;

@RestController
public class BlogController {

	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	

	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired 
	private Blog blog;
	

	
	@GetMapping("/blogs")
	public  ResponseEntity<List<Blog>> getBlogs() {
		logger.debug("calling method getBlogs");
	    List<Blog> list=  	blogDAO.list();
	    if(list.isEmpty())
	    {
	    	return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}

	@GetMapping("/blog/{id}")
	@RequestMapping(consumes="application/x-www-form-urlencoded",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") String id) {
		logger.debug("calling method getBlogs with the id " + id);
		blog = blogDAO.get(id);
		if (blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@PostMapping(value = "/blog")
	@RequestMapping(consumes="application/json",produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		logger.debug("calling method createBlog");

		blogDAO.saveOrUpdate(blog);

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@DeleteMapping("/blog/{id}")
	@RequestMapping(consumes="application/x-www-form-urlencoded",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> deleteBlog(@PathVariable String id) {
		logger.debug("calling method deleteBlog with the id " + id);

		if (blogDAO.get(id)!=null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.delete(id);
		return new ResponseEntity<Blog>( HttpStatus.OK);

	}

	@PutMapping("/blog/{id}")
	@RequestMapping(consumes="application/x-www-form-urlencoded",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> updateBlog(@PathVariable String id, @RequestBody Blog blog) {
		logger.debug("calling method updateBlog with the id " + id);
		
		if (blogDAO.get(id)==null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

}
