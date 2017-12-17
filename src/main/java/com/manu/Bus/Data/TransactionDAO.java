package com.manu.Bus.Data;

import java.sql.SQLException;
import java.util.List;

import com.manu.Bus.POJO.SeatLayout;

public interface TransactionDAO {
	
	public List<SeatLayout> getAvailableBusses(String source,String destination)throws SQLException,ClassNotFoundException; 

}
