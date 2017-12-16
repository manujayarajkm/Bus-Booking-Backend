package com.manu.Bus.POJO;

import java.util.Date;

public class Booking {
	
	private int bookingId;
	private int userId;
	private int routeId;
	private int busId;
	private int noOfSeats;
	private String source;
	private String destination;
	private String busType;
	private int amount;
	private Date bookingDate;
	public Booking() {
		super();
	}
	public Booking(int bookingId, int userId, int routeId, int busId, int noOfSeats, String source, String destination,
			String busType, int amount, Date bookingDate) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.routeId = routeId;
		this.busId = busId;
		this.noOfSeats = noOfSeats;
		this.source = source;
		this.destination = destination;
		this.busType = busType;
		this.amount = amount;
		this.bookingDate = bookingDate;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", routeId=" + routeId + ", busId=" + busId
				+ ", noOfSeats=" + noOfSeats + ", source=" + source + ", destination=" + destination + ", busType="
				+ busType + ", amount=" + amount + ", bookingDate=" + bookingDate + "]";
	}

}
