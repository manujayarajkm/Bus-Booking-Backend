package com.manu.Bus.Data;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.SeatLayout;
import com.manu.Bus.POJO.Stops;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	private final static String GETSOURCEROUTES="SELECT route_id,stop_value FROM stops where stop_name=? ";
	private final static String GETDESTROUTES="SELECT route_id,stop_value FROM stops where stop_name=?";
	private final static String GETBUSIDS="SELECT bus_id FROM bus_and_route where route_id=?";
	private final static String GETSEATLAYOUT="select bus.bus_id,bus.bus_name,bus.bus_type,bus.`bus_start_time`,seat.`seat_no`,seat.`seat_status`,seat.booked_value from bus INNER JOIN seat ON seat.`bus_id`=bus.bus_id and bus.`bus_id`=?;";
	private final static String GETBUSSES="SELECT * FROM bus where route_id=? && bus_start_time>?";



	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Bus> getAvailableBusses(String source, String destination)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Integer> rIds=new ArrayList();
		List<Integer> busIds=new ArrayList();
		List<SeatLayout> seatLayout=new ArrayList();
		List<Bus> bus=new ArrayList();
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
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH.mm");
		String t=format.format(date);
		float time=Float.parseFloat(t);
		System.out.println(time);
//		for(int i=0;i<rIds.size();i++){
//			System.out.println(rIds.get(i));
//			int busId=jdbcTemplate.queryForObject(GETBUSIDS, new Object[]{rIds.get(i)},Integer.class);
//			busIds.add(busId);
//		}
//		System.out.println(busIds);
//		for(int i=0;i<busIds.size();i++){
//			List<SeatLayout> seatLayout1=new ArrayList();
//			seatLayout1=jdbcTemplate.query(GETSEATLAYOUT, new SeatLayoutMapper(),busIds.get(i));
//			seatLayout.addAll(seatLayout1);
//		}
//		System.out.println(seatLayout);
		for(int i=0;i<rIds.size();i++){
			List<Bus> bus1=new ArrayList();
			System.out.println(rIds.get(i));
			bus1=jdbcTemplate.query(GETBUSSES, new BusMapper(),rIds.get(i),time);
			System.out.println(bus1);
			bus.addAll(bus1);
		}
		System.out.println(bus);
				
		
		return bus;
	}

	@Override
	public List<SeatLayout> getSeatStatus(int busId,int sourceValue) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<SeatLayout> seatLayout=jdbcTemplate.query(GETSEATLAYOUT,new SeatLayoutMapper(),busId);
		for(int i=0;i<seatLayout.size();i++){
			if(seatLayout.get(i).getDestValue()<=sourceValue){
				seatLayout.get(i).setSeatStatus("available");
			}
		}
		return seatLayout;
	}

}
