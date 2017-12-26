package com.manu.Bus.POJO;

public class Passenger {

	private String passengerName;
	private String passengerGender;
	private int passengerAge;
	private int bookingId;
	public Passenger() {
		super();
	}

	public Passenger(String passengerName, String passengerGender, int passengerAge,int bookingId) {
		super();
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.bookingId=bookingId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", passengerGender=" + passengerGender + ", passengerAge="
				+ passengerAge + ", bookingId=" + bookingId + "]";
	}

	
}
