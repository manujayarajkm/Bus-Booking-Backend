package com.manu.Bus.POJO;

public class Bus_and_Route {
	
	private int busRouteId;
	private int busId;
	private int routeId;
	public Bus_and_Route() {
		super();
	}
	public Bus_and_Route(int busRouteId, int busId, int routeId) {
		super();
		this.busRouteId = busRouteId;
		this.busId = busId;
		this.routeId = routeId;
	}
	public int getBusRouteId() {
		return busRouteId;
	}
	public void setBusRouteId(int busRouteId) {
		this.busRouteId = busRouteId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "Bus_and_Route [busRouteId=" + busRouteId + ", busId=" + busId + ", routeId=" + routeId + "]";
	}

}
