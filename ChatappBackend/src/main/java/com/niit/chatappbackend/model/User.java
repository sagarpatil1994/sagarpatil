package com.niit.chatappbackend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "user")
@Component
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
@Column
	private String name;
@Column
	private String password;
@Column
	private int mobile;
@Column
	private String email;
@Column
	private String address;

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="admin", columnDefinition="tinyinit default 0")
	private byte admin;

	public byte getAdmin()
	{
		return admin;
	}
	public void setAdmin(byte admin)
	{
		this.admin = admin;
	}
}
