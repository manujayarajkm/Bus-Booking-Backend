package com.manu.Bus.Data;

import java.sql.SQLException;

public interface UserDAO {
	
	public String registerUser(String name,String email,double phone,String username,String password,String gender,int age)throws SQLException,ClassNotFoundException;

}
