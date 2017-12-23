package com.manu.Bus.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manu.Bus.POJO.Booked_Seats;

public class BookedSeatsMpper implements RowMapper<Booked_Seats> {

	@Override
	public Booked_Seats mapRow(ResultSet rS, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Booked_Seats bookedSeats=new Booked_Seats();
		bookedSeats.setBookedSeatsId(rS.getInt(1));
		bookedSeats.setUserId(rS.getInt(2));
		bookedSeats.setSeatNo(rS.getInt(3));
		bookedSeats.setBusId(rS.getInt(4));
		java.util.Date date1=rS.getDate(5);
		bookedSeats.setTravelDate(date1);
		bookedSeats.setDestValue(rS.getInt(6));
		
		return bookedSeats;
	}

}
