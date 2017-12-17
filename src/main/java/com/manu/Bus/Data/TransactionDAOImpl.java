package com.manu.Bus.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manu.Bus.POJO.SeatLayout;
import com.manu.Bus.POJO.StopMapper;
import com.manu.Bus.POJO.Stops;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	private final static String GETSOURCEROUTES="SELECT route_id,stop_value FROM stops where stop_name=? ";
	private final static String GETDESTROUTES="SELECT route_id,stop_value FROM stops where stop_name=?";


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<SeatLayout> getAvailableBusses(String source, String destination)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Integer> rIds=new ArrayList();
		List<Stops> sourcestops=jdbcTemplate.query(GETSOURCEROUTES,new StopMapper(),source);
		System.out.println(sourcestops);
		List<Stops> deststops=jdbcTemplate.query(GETDESTROUTES,new StopMapper(),destination);
		System.out.println(deststops);
		
		for(int i=0;i<sourcestops.size();i++){
			for (int j=0;j<deststops.size();j++){
				if(sourcestops.get(i).getRouteId()==deststops.get(j).getRouteId() && sourcestops.get(i).getStopValue()<deststops.get(j).getStopValue()){
					rIds.add(sourcestops.get(i).getRouteId());
				}
			}
		}
		System.out.println(rIds);
		return null;
	}

}
