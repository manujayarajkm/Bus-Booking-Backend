package com.manu.Bus.Data;

import java.sql.SQLException;

import com.manu.Bus.POJO.User;

public interface UserDAO {
	
	public String registerUser(String name,String email,double phone,String username,String password,String gender,int age)throws SQLException,ClassNotFoundException;
	public User login(String username,String password)throws SQLException,ClassNotFoundException;
}
