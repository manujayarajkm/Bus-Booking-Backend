package com.manu.Bus.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manu.Bus.Data.TransactionDAO;
import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.SeatLayout;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDAO transactionDAO;
	
	@Override
	public List<Bus> getAvailableBusses(String source, String destination)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return transactionDAO.getAvailableBusses(source, destination);
	}

	@Override
	public List<SeatLayout> getSeatStatus(int busId,int  sourceValue,LocalDate travelDate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
		return transactionDAO.getSeatStatus(busId,sourceValue,travelDate);
	}

}
