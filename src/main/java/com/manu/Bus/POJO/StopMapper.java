package com.manu.Bus.POJO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StopMapper implements RowMapper<Stops> {

	@Override
	public Stops mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Stops stopsRow=new Stops();
		stopsRow.setRouteId(rs.getInt(1));
		stopsRow.setStopValue(rs.getInt(2));
		return stopsRow;
	}

}
