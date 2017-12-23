package com.manu.Bus.Data;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private final static String REGISTERUSER="insert into user(name,email,user_contact,username,password,gender,age) values(?,?,?,?,?,?,?)";


	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	@Override
	public String registerUser(String name, String email, double phone, String username, String password, String gender,
			int age) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		int rowCount=jdbctemplate.update(REGISTERUSER,name,email,phone,username,password,gender,age);
		if(rowCount>0){
			return "success";
		}
		else
		{
			return "failure";
		}
		
	}

}
