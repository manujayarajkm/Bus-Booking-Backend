package com.manu.Bus.Controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.Seat;
import com.manu.Bus.POJO.SeatLayout;
import com.manu.Bus.POJO.User;
import com.manu.Bus.Service.TransactionService;
import com.manu.Bus.Service.UserService;

@RestController
@RequestMapping(value="/buscontroller")
public class BusController {
	
	@Autowired
	TransactionService transactionService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getAvailableBussess/{source}/{dest}",method=RequestMethod.GET)
	public List<Bus> getAvailableBussess(@PathVariable String source,@PathVariable String dest) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Got the call");
		return transactionService.getAvailableBusses(source, dest);
	}
	@RequestMapping(value="/getSeatLayout/{busId}/{destValue}/{travelDate}",method=RequestMethod.GET)
	public List<SeatLayout> getSeatLayout(@PathVariable int busId,@PathVariable int destValue,@PathVariable String travelDate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		LocalDate localDate = LocalDate.parse(travelDate); 
		
		System.out.println("Got the call "+localDate);
		return transactionService.getSeatStatus(busId,destValue,localDate);
	}
	@RequestMapping(value="/registerUser/{name}/{email}/{phone}/{username}/{password}/{gender}/{age}",method=RequestMethod.GET)
	public String registerUser(@PathVariable String name,@PathVariable String email,@PathVariable double phone,@PathVariable String username,@PathVariable String password,@PathVariable String gender,@PathVariable int age) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Got the call ");
		return userService.registerUser(name, email, phone, username, password, gender, age);
	}
	@RequestMapping(value="/getDestValue/{destination}/{routeId}",method=RequestMethod.GET)
	public int getDestValue(@PathVariable String destination,@PathVariable int routeId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Got the call ");
		return transactionService.destvalue(destination, routeId);
	}
	@RequestMapping(value="/login/{username}/{password}",method=RequestMethod.GET)
	public User login(@PathVariable String username,@PathVariable String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Got the call ");
		return userService.login(username, password);
	}
}
