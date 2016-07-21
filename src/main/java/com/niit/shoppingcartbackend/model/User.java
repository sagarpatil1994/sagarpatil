package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "user")
@Component
public class User {
@Id
	private String id;
    private String name;
    private String password;
    private int mobileno;
    private String mail;
    private String address;
	public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getMobileno() {
	return mobileno;
}
public void setMobileno(int mobileno) {
	this.mobileno = mobileno;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	}
	
	

