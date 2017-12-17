package com.manu.Bus.Service;

import java.sql.SQLException;
import java.util.List;

import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.SeatLayout;

public interface TransactionService {

	public List<Bus> getAvailableBusses(String source,String destination)throws SQLException,ClassNotFoundException; 
	public List<SeatLayout> getSeatStatus(int busId)throws SQLException,ClassNotFoundException; 

}
