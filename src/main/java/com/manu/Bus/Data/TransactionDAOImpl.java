package com.manu.Bus.Data;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manu.Bus.POJO.Booked_Seats;
import com.manu.Bus.POJO.Bus;
import com.manu.Bus.POJO.Passenger;
import com.manu.Bus.POJO.SeatLayout;
import com.manu.Bus.POJO.Stops;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	private final static String GETSOURCEROUTES="SELECT route_id,stop_value,distance_from_origin,time_from_origin FROM stops where stop_name=? ";
	private final static String GETDESTROUTES="SELECT route_id,stop_value,distance_from_origin,time_from_origin FROM stops where stop_name=?";
	private final static String GETBUSIDS="SELECT bus_id FROM bus_and_route where route_id=?";
	private final static String GETSEATLAYOUT="select bus.bus_id,bus.bus_name,bus.bus_type,bus.`bus_start_time`,seat.`seat_no`,seat.`seat_status`,seat.booked_value from bus INNER JOIN seat ON seat.`bus_id`=bus.bus_id and bus.`bus_id`=?;";
	private final static String GETBUSSES="SELECT * FROM bus where route_id=? && bus_start_time>?";
	private final static String GETNOOFSEATS="SELECT count(seat_no) FROM seat where bus_id=?";
	private final static String GETSEATSTATUS="select `booked_seats_id` from booked_seats where bus_id=? and `seat_no`=? and `travel_date`=?";
	private final static String GETBOOKEDSEATS="select * from booked_seats where bus_id=?";
	private final static String GETBOOKEDSEATNO="select seat_no from booked_seats where bus_id=?";
	private final static String GETSOURCETIME="select time_from_origin from stops where route_id=? && stop_name=?";
	private final static String GETDESTTIME="select time_from_origin from stops where route_id=? && stop_name=?";
	private final static String GETBUSTYPE="select bus_type from bus where bus_id=?";
	private final static String GETSOURCEDIST="select distance_from_origin from stops where route_id=? && stop_name=?";
	private final static String GETDESTDIST="select distance_from_origin from stops where route_id=? && stop_name=?";
	private final static String GETDESTVALUE="select stop_value from stops where stop_name=? && route_id=?";
	private final static String ADDBOOKING="insert into booking (user_id,route_id,bus_id,no_of_seats_booked,source,destination,bus_type,total_amount,booking_date) values(?,?,?,?,?,?,?,?,?)";
	private final static String UPDATEBOOKEDSEATS="insert into booked_seats (user_id,seat_no,bus_id,travel_date,dest_value) values(?,?,?,?,?)";
	private final static String UPDATEPASSENGER="insert into passenger(passenger_name,passenger_gender,passenger_age,booking_id) values(?,?,?,?)";

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
//					float duration=(deststops.get(j).getTimeWROrigin()-sourcestops.get(i).getTimeWROrigin());
//					System.out.println("Time is "+duration);
//					float reachtime=(deststops.get(j).getTimeWROrigin());
//					System.out.println("Time is "+reachtime);
//					float distance=(deststops.get(j).getDistanceFromorigin()-sourcestops.get(i).getDistanceFromorigin());
//					System.out.println("Distance  is "+distance);
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
			System.out.println("before time "+bus1);
			System.out.println("source is "+source);
			System.out.println("destination is "+destination);
			float sourceTime=jdbcTemplate.queryForObject(GETSOURCETIME, new Object[]{rIds.get(i),source},Float.class);
			float destTime=jdbcTemplate.queryForObject(GETDESTTIME, new Object[]{rIds.get(i),destination},Float.class);
			System.out.println("Source time "+sourceTime +"dest time "+destTime);
			int sourceDist=jdbcTemplate.queryForObject(GETSOURCEDIST, new Object[]{rIds.get(i),source},Integer.class);
			int destDist=jdbcTemplate.queryForObject(GETDESTDIST, new Object[]{rIds.get(i),destination},Integer.class);
			int distance=destDist-sourceDist;
			System.out.println("Source distance "+sourceDist +"dest distance "+destDist);
			System.out.println(bus1);
			bus.addAll(bus1);
			String busType=bus.get(i).getBusType();
			System.out.println("bus type "+busType);
			int fare=calculateFare(busType,distance);
			Float startTime=bus.get(i).getStartTime();
			bus.get(i).setReachTime(startTime+destTime);
			bus.get(i).setCost(fare);
		}
		System.out.println(bus);
				
		
		return bus;
	}

	@Override
	public List<SeatLayout> getSeatStatus(int busId,int sourceValue,LocalDate travelDate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		int noOfSeats=jdbcTemplate.queryForObject(GETNOOFSEATS, new Object[]{busId},Integer.class);
		List<Integer> seats=new ArrayList();
		List<Integer> availSeats=new ArrayList();
		List<Integer> booked=new ArrayList();
		List<Integer> willAvailable=new ArrayList();
		System.out.println("no of seats "+noOfSeats);
		for(int i=1;i<=noOfSeats;i++){
			System.out.println("Inside for loop "+i);
			try{
				System.out.println("Inside try");
				System.out.println("Date is "+travelDate);
			int seatId=jdbcTemplate.queryForObject(GETSEATSTATUS, new Object[]{busId,i,travelDate},Integer.class);
			System.out.println(seatId);
			seats.add(i);
			}catch(EmptyResultDataAccessException e){
				System.out.println("Inside catch");
				System.out.println("id not exist");
				availSeats.add(i);

			}
		}
		System.out.println("booked seats array "+seats);
		System.out.println("available seats array "+availSeats);
		List<SeatLayout> seatLayout=jdbcTemplate.query(GETSEATLAYOUT,new SeatLayoutMapper(),busId);
		List<Booked_Seats> booked_seats=jdbcTemplate.query(GETBOOKEDSEATS,new BookedSeatsMpper(),busId);
		for(int i=0;i<seats.size();i++){
			System.out.println("inside i loop");
			for(int j=0;j<booked_seats.size();j++){
				System.out.println("inside j loop");
			if(seats.get(i)==booked_seats.get(j).getSeatNo()){
				System.out.println("found seat number match " +booked_seats.get(j).getSeatNo());
				if(booked_seats.get(j).getDestValue()<=sourceValue){
					System.out.println("found a possible vaccant seat "+booked_seats.get(j).getSeatNo()+booked_seats.get(j).getDestValue()+sourceValue);
				//seatLayout.get(i).setSeatStatus("available");
					willAvailable.add(seats.get(i));
			}
				else{
					//seatLayout.get(i).setSeatStatus("booked");
					System.out.println("Seat wil be booked only "+booked_seats.get(j).getSeatNo());
					booked.add(seats.get(i));

				}
			}
		}
		}
		System.out.println("New booked seats array after check "+booked);
		System.out.println("new available seats array after check "+willAvailable);
//		for(int j=0;j<seatLayout.size();j++){
//			for(int i=0;i<seats.size();i++){
//			if(seatLayout.get(j).getSeatNo()==seats.get(i)){
//				System.out.println(" seatlayout "+j +"seats "+i);
//				seatLayout.get(j).setSeatStatus("booked");
//			}
//			}
//		}
		for(int i=0;i<seatLayout.size();i++){
			for(int j=0;j<availSeats.size();j++){
				if(seatLayout.get(i).getSeatNo()==availSeats.get(j)){
					seatLayout.get(i).setSeatStatus("available");
				}
			}
		}
		for(int i=0;i<seatLayout.size();i++){
			for(int j=0;j<willAvailable.size();j++){
				if(seatLayout.get(i).getSeatNo()==willAvailable.get(j)){
					seatLayout.get(i).setSeatStatus("available");
				}
			}
		}
		for(int i=0;i<seatLayout.size();i++){
			for(int j=0;j<booked.size();j++){
				if(seatLayout.get(i).getSeatNo()==booked.get(j)){
					seatLayout.get(i).setSeatStatus("booked");
				}
			}
		}
		
		return seatLayout;
	}

	@Override
	public int calculateFare(String busType, int distance) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int baserate=0;
		int rateWithKm=0;
		int totalrate=0;
		
		switch(busType){
		case "express":
			baserate=150;
			rateWithKm=10;
			totalrate=baserate+(distance*rateWithKm);
			break;
		case "ac":
			baserate=300;
			rateWithKm=25;
			totalrate=baserate+(distance*rateWithKm);
			break;
		case "superfast":
			baserate=100;
			rateWithKm=5;
			totalrate=baserate+(distance*rateWithKm);
			break;
		default:
			totalrate=0;
			
		}
		return totalrate;
	}

	@Override
	public int destvalue(String destination,int routeId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int destValue=jdbcTemplate.queryForObject(GETDESTVALUE, new Object[]{destination,routeId},Integer.class);
		return destValue;
	}

	@Override
	public String bookSeat(int routeId,int userId, int busId, int[] seats, String source, String destination, String busType,
			int amount,LocalDate traveldate) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		LocalDate bookDate=LocalDate.now();

		int rowCount=jdbcTemplate.update(ADDBOOKING,userId,routeId,busId,seats.length, source, destination, busType,amount,java.sql.Date.valueOf(bookDate));
		if(rowCount>0){
			int destvalue=jdbcTemplate.queryForObject(GETDESTVALUE, new Object[]{destination,routeId},Integer.class);
			for(int i=0;i<seats.length;i++){
				int updateId=jdbcTemplate.update(UPDATEBOOKEDSEATS,userId,seats[i],busId,java.sql.Date.valueOf(traveldate),destvalue);
			}
			return "success";
		}
		else{
			return "failure";
		}
		
	}

	@Override
	public String addPassenger(Passenger[] passenger) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int rowCount=0;
		for(int i=0;i<passenger.length;i++){
			rowCount=jdbcTemplate.update(UPDATEPASSENGER,passenger[i].getPassengerName(),passenger[i].getPassengerGender(),passenger[i].getPassengerAge(),passenger[i].getBookingId());
		}
		if(rowCount>0){
			return "success";
		}
		else
		{
			return "failed";
		}
	}

}
