package com.manu.Bus.Service;

import java.sql.SQLException;
import java.util.List;

import com.manu.Bus.POJO.SeatLayout;

public interface TransactionService {

	public List<SeatLayout> getAvailableBusses(String source,String destination)throws SQLException,ClassNotFoundException; 

}
