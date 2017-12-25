package com.manu.Bus.Data;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manu.Bus.POJO.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private final static String REGISTERUSER="insert into user(name,email,user_contact,username,password,gender,age) values(?,?,?,?,?,?,?)";
	private final static String LOGIN="select user_id from user where username=? && password=?";
	private final static String RETREIVE_NAME="select name from user where user_id=?";
	private final static String RETREIVE_EMAIL="select email from user where user_id=?";
	private final static String RETREIVE_PHONE="select user_contact from user where user_id=?";
	private final static String RETREIVE_USERNAME="select username from user where user_id=?";
	private final static String RETREIVE_GENDER="select gender from user where user_id=?";
	private final static String RETREIVE_AGE="select age from user where user_id=?";

	

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


	@Override
	public User login(String username, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		try{
			int userId=jdbctemplate.queryForObject(LOGIN,new Object[]{username,password},Integer.class);
			String email=jdbctemplate.queryForObject(RETREIVE_EMAIL,new Object[]{userId},String.class);
			String name=jdbctemplate.queryForObject(RETREIVE_NAME,new Object[]{userId},String.class);
			double phone=jdbctemplate.queryForObject(RETREIVE_PHONE,new Object[]{userId},Double.class);
			String uname=jdbctemplate.queryForObject(RETREIVE_USERNAME,new Object[]{userId},String.class);
			int  age=jdbctemplate.queryForObject(RETREIVE_AGE,new Object[]{userId},Integer.class);
			String gender=jdbctemplate.queryForObject(RETREIVE_GENDER,new Object[]{userId},String.class);

			User user=new User();
			user.setUserid(userId);
			user.setName(name);
			user.setEmail(email);
			user.setUserPhone(phone);
			user.setUsername(uname);
			user.setAge(age);
			user.setGender(gender);
			return user;
		}catch(EmptyResultDataAccessException e){
			
			User user=new User();
			user.setUserid(0);
			return user;
		}

	}

}
