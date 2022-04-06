package com.split_pay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String username;
	@Column(name="user_email", unique=true)
	private String userEmail;
	private String userMobile;
	private String password;


	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String username, String userEmail, String userMobile,String password,Integer g_id) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.password =password;
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
