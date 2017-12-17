package com.manu.Bus.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manu.Bus.POJO.SeatLayout;

public class SeatLayoutMapper implements RowMapper<SeatLayout> {

	@Override
	public SeatLayout mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		SeatLayout seatLayout=new SeatLayout();
		seatLayout.setBusId(rs.getInt(1));
		seatLayout.setBusName(rs.getString(2));
		seatLayout.setBusType(rs.getString(3));
		seatLayout.setBus_start_time(rs.getFloat(4));
		seatLayout.setSeatNo(rs.getInt(5));
		seatLayout.setSeatStatus(rs.getString(6));
		seatLayout.setDestValue(rs.getInt(7));
		return seatLayout;
	}

}
