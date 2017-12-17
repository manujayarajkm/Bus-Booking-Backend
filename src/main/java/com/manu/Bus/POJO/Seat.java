package com.manu.Bus.POJO;

public class Seat {
	
	private int statusId;
	private int seatId;
	private int busId;
	private int seatNo;
	private String seatStatus;
	public Seat() {
		super();
	}
	public Seat(int statusId, int seatId, int busId, int seatNo, String seatStatus) {
		super();
		this.statusId = statusId;
		this.seatId = seatId;
		this.busId = busId;
		this.seatNo = seatNo;
		this.seatStatus = seatStatus;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
	@Override
	public String toString() {
		return "Seat_Status [statusId=" + statusId + ", seatId=" + seatId + ", busId=" + busId + ", seatNo=" + seatNo
				+ ", seatStatus=" + seatStatus + "]";
	}
	

}
