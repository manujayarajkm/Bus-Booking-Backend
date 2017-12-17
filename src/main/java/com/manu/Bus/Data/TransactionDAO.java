package com.manu.Bus.Data;

import java.sql.SQLException;
import java.util.List;

import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.SeatLayout;

public interface TransactionDAO {
	
	public List<Bus> getAvailableBusses(String source,String destination)throws SQLException,ClassNotFoundException; 
	public List<SeatLayout> getSeatStatus(int busId,int  sourceValue)throws SQLException,ClassNotFoundException; 
	

}
