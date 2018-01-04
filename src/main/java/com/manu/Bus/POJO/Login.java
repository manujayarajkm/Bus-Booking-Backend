package com.manu.Bus.POJO;

public class Login {
	
	private String username;
	private String password;
	private int userId;

	public Login() {
		super();
	}

	public Login(String username, String password, int userId) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", userId=" + userId + "]";
	}

}
