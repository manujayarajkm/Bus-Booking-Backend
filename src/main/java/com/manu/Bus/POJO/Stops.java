package com.manu.Bus.POJO;

public class Stops {
	private int stopId;
	private int routeId;
	private String stopName;
	private int stopValue;
	private int distanceFromorigin;
	private float timeWROrigin;
	public Stops() {
		super();
	}
	public Stops(int stopId, int routeId, String stopName, int stopValue, int distanceFromorigin, float timeWROrigin) {
		super();
		this.stopId = stopId;
		this.routeId = routeId;
		this.stopName = stopName;
		this.stopValue = stopValue;
		this.distanceFromorigin = distanceFromorigin;
		this.timeWROrigin = timeWROrigin;
	}
	public int getStopId() {
		return stopId;
	}
	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public int getStopValue() {
		return stopValue;
	}
	public void setStopValue(int stopValue) {
		this.stopValue = stopValue;
	}
	public int getDistanceFromorigin() {
		return distanceFromorigin;
	}
	public void setDistanceFromorigin(int distanceFromorigin) {
		this.distanceFromorigin = distanceFromorigin;
	}
	public float getTimeWROrigin() {
		return timeWROrigin;
	}
	public void setTimeWROrigin(int timeWROrigin) {
		this.timeWROrigin = timeWROrigin;
	}
	@Override
	public String toString() {
		return "Stops [stopId=" + stopId + ", routeId=" + routeId + ", stopName=" + stopName + ", stopValue="
				+ stopValue + ", distanceFromorigin=" + distanceFromorigin + ", timeWROrigin=" + timeWROrigin + "]";
	}

}
