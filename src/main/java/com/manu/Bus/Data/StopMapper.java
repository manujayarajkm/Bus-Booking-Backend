package com.manu.Bus.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manu.Bus.POJO.Stops;

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
