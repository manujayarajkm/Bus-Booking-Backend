package com.manu.Bus.POJO;

public class SeatLayout {
	private int busId;
	private String busName;
	private float bus_start_time;
	private float reachTime;
	private int seatNo;
	private String seatStatus;
	private String busType;
	private int destValue;
	public SeatLayout() {
		super();
	}
	public SeatLayout(int busId, String busName, float bus_start_time, float reachTime, int seatNo, String seatStatus,String busType,int destValue) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.bus_start_time = bus_start_time;
		this.reachTime = reachTime;
		this.seatNo = seatNo;
		this.seatStatus = seatStatus;
		this.busType=busType;
		this.destValue=destValue;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public float getBus_start_time() {
		return bus_start_time;
	}
	public void setBus_start_time(float bus_start_time) {
		this.bus_start_time = bus_start_time;
	}
	public float getReachTime() {
		return reachTime;
	}
	public void setReachTime(float reachTime) {
		this.reachTime = reachTime;
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
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getDestValue() {
		return destValue;
	}
	public void setDestValue(int destValue) {
		this.destValue = destValue;
	}
	@Override
	public String toString() {
		return "SeatLayout [busId=" + busId + ", busName=" + busName + ", bus_start_time=" + bus_start_time
				+ ", reachTime=" + reachTime + ", seatNo=" + seatNo + ", seatStatus=" + seatStatus + "]";
	}

}
