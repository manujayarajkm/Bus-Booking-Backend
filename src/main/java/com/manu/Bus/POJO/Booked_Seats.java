package com.manu.Bus.POJO;

import java.util.Date;

public class Booked_Seats {
	
	private int bookedSeatsId;
	private int userId;
	private int seatNo;
	private int busId;
	private Date travelDate;
	private int destValue;
	public Booked_Seats() {
		super();
	}
	public Booked_Seats(int bookedSeatsId, int userId, int seatNo, int busId,Date travelDate,int destValue) {
		super();
		this.bookedSeatsId = bookedSeatsId;
		this.userId = userId;
		this.seatNo = seatNo;
		this.busId = busId;
		this.travelDate=travelDate;
		this.destValue=destValue;
	}
	public int getBookedSeatsId() {
		return bookedSeatsId;
	}
	public void setBookedSeatsId(int bookedSeatsId) {
		this.bookedSeatsId = bookedSeatsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public int getDestValue() {
		return destValue;
	}
	public void setDestValue(int destValue) {
		this.destValue = destValue;
	}
	@Override
	public String toString() {
		return "Booked_Seats [bookedSeatsId=" + bookedSeatsId + ", userId=" + userId + ", seatNo=" + seatNo + ", busId="
				+ busId + "]";
	}
	

}
