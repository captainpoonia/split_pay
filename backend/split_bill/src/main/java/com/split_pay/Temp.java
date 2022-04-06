package com.split_pay;

public class Temp {
	private String username;
	private String userEmail;
    private Integer g_id;
	public Temp() {

	}
	public Temp(String username, String userEmail, Integer g_id) {
		super();
		this.username = username;
		this.userEmail = userEmail;
		this.g_id = g_id;
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
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	@Override
	public String toString() {
		return "Temp [username=" + username + ", userEmail=" + userEmail + ", g_id=" + g_id + "]";
	}

	
	
}
