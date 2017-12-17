package com.manu.Bus.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manu.Bus.POJO.Bus;

public class BusMapper implements RowMapper<Bus> {

	@Override
	public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Bus bus=new Bus();
		bus.setBusId(rs.getInt(1));
		bus.setBusName(rs.getString(2));
		bus.setBusType(rs.getString(3));
		bus.setNoOfSeats(rs.getInt(4));
		bus.setContactNo(rs.getDouble(5));
		bus.setStartTime(rs.getFloat(6));
		bus.setRouteId(rs.getInt(7));
		return bus;
	}

}
