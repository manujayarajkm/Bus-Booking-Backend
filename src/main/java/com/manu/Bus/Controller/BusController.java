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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manu.Bus.POJO.Booking;
import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.Passenger;
import com.manu.Bus.POJO.Seat;
import com.manu.Bus.POJO.SeatLayout;
import com.manu.Bus.POJO.Time;
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
	
	@RequestMapping(value="/getAvailableBussess/{source}/{dest}/{traveldate}",method=RequestMethod.GET)
	public List<Bus> getAvailableBussess(@PathVariable String source,@PathVariable String dest,@PathVariable String traveldate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Got the call");
		LocalDate localDate = LocalDate.parse(traveldate);
		return transactionService.getAvailableBusses(source, dest,localDate);
	}
	@RequestMapping(value="/getSeatLayout/{busId}/{destValue}/{travelDate}",method=RequestMethod.GET)
	public List<SeatLayout> getSeatLayout(@PathVariable int busId,@PathVariable int destValue,@PathVariable String travelDate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
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
//	@RequestMapping(value="/bookseats/{routeId}/{userId}/{busId}/{seats}/{source}/{destination}/{busType}/{amount}/{traveldate}",method=RequestMethod.GET)
//	public String bookSeats(@PathVariable int  routeId,@PathVariable int userId,@PathVariable int busId,@PathVariable int[] seats,@PathVariable String source,
//			@PathVariable String destination,@PathVariable String busType,@PathVariable int amount,@PathVariable String traveldate) throws SQLException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		
//		LocalDate localDate = LocalDate.parse(traveldate);
//		System.out.println("Got the call ");
//		System.out.println(seats);
//		return transactionService.bookSeat(routeId, userId, busId, seats, source, destination, busType, amount, localDate);
//	}
	@RequestMapping(value="/bookseats",method=RequestMethod.POST,consumes="application/json")
	public int bookSeats(@RequestBody Booking bookingObj,Model model) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(bookingObj);
		int routeId=bookingObj.getRouteId();
		int userid=bookingObj.getUserId();
		int busId=bookingObj.getBusId();
		int[] seats=bookingObj.getSeats();
		String source=bookingObj.getSource();
		String destination=bookingObj.getDestination();
		String busType=bookingObj.getBusType();
		int amount=bookingObj.getAmount();
		String date=bookingObj.getBookingDate();
		LocalDate ldate=LocalDate.parse(date);
		return transactionService.bookSeat(routeId, userid, busId, seats, source, destination, busType, amount, ldate);
		
	}
	@RequestMapping(value="/addpassenger",method=RequestMethod.POST,consumes="application/json")
	public String addPassenger(@RequestBody Passenger passengerObj,Model model) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(passengerObj);
		
		return transactionService.addPassenger(passengerObj);
	}
	@RequestMapping(value="/convert",method=RequestMethod.POST,consumes="application/json")
	public String timeconvert(@RequestBody Time timeObj,Model model) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(timeObj.getTime());
		float value=timeObj.getTime();
		System.out.println(value);

		int hours = (int) value;
		if(hours>23){
			hours-=24;
		}
		int fraction=(int)((value % 1)*100);	
		if(fraction>59){
			fraction-=60;
			hours++;
		}
		System.out.println(hours+"."+fraction);


		return null;
	}
	
	
}
