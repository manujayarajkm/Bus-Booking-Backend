package com.manu.Bus.Service;

import java.sql.SQLException;

public interface UserService {
	
	public String registerUser(String name,String email,double phone,String username,String password,String gender,int age)throws SQLException,ClassNotFoundException;


}
