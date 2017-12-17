package com.manu.Bus.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.Seat;
import com.manu.Bus.POJO.SeatLayout;
import com.manu.Bus.Service.TransactionService;

@RestController
@RequestMapping(value="/buscontroller")
public class BusController {
	
	@Autowired
	TransactionService transactionService;
	@RequestMapping(value="/getAvailableBussess/{source}/{dest}",method=RequestMethod.GET)
	public List<Bus> getAvailableBussess(@PathVariable String source,@PathVariable String dest) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Got the call");
		return transactionService.getAvailableBusses(source, dest);
	}
	@RequestMapping(value="/getSeatLayout/{busId}",method=RequestMethod.GET)
	public List<SeatLayout> getSeatLayout(@PathVariable int busId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Got the call");
		return transactionService.getSeatStatus(busId);
	}
}
