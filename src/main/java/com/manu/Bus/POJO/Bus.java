package com.manu.Bus.POJO;

public class Bus {
	private int busId;
	private String busName;
	private String busType;
	private int noOfSeats;
	private float startTime;
	private double contactNo;
	private float reachTime;
	private int cost;
	int routeId;
	public Bus() {
		super();
	}
	public Bus(int busId, String busName, String busType, int noOfSeats, float startTime, double contactNo,int routeId,float reachTime,int cost) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = busType;
		this.noOfSeats = noOfSeats;
		this.startTime = startTime;
		this.contactNo = contactNo;
		this.routeId=routeId;
		this.reachTime=reachTime;
		this.cost=cost;
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
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public float getStartTime() {
		return startTime;
	}
	public void setStartTime(float startTime) {
		this.startTime = startTime;
	}
	public double getContactNo() {
		return contactNo;
	}
	public void setContactNo(double contactNo) {
		this.contactNo = contactNo;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public float getReachTime() {
		return reachTime;
	}
	public void setReachTime(float reachTime) {
		this.reachTime = reachTime;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + ", noOfSeats=" + noOfSeats
				+ ", startTime=" + startTime + ", contactNo=" + contactNo + "]";
	}

}
