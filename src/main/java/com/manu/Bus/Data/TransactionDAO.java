package com.manu.Bus.Data;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.SeatLayout;

public interface TransactionDAO {
	
	public List<Bus> getAvailableBusses(String source,String destination)throws SQLException,ClassNotFoundException; 
	public List<SeatLayout> getSeatStatus(int busId,int  sourceValue,LocalDate travelDate)throws SQLException,ClassNotFoundException; 
	public int calculateFare(String busType,int distance)throws SQLException,ClassNotFoundException;
	public int destvalue(String destination,int routeId)throws SQLException,ClassNotFoundException;
	public String bookSeat(int routeId,int userId,int busId,int [] seats,String source,String destination,String busType,int amount,LocalDate traveldate)throws SQLException,ClassNotFoundException;
}
