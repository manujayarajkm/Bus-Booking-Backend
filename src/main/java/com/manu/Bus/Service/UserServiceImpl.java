package com.manu.Bus.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manu.Bus.Data.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public String registerUser(String name, String email, double phone, String username, String password, String gender,
			int age) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.registerUser(name, email, phone, username, password, gender, age);
	}

}
