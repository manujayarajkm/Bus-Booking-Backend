package com.manu.Bus.POJO;

public class User {
	private int userid;
	private String name;
	private String email;
	private double userPhone;
	private String username;
	private String password;
	private char gender;
	private int age;
	public User() {
		super();
	}
	public User(int userid, String name, String email, double userPhone, String username, String password, char gender,
			int age) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.userPhone = userPhone;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(double userPhone) {
		this.userPhone = userPhone;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", userPhone=" + userPhone
				+ ", username=" + username + ", password=" + password + ", gender=" + gender + ", age=" + age + "]";
	}

}
