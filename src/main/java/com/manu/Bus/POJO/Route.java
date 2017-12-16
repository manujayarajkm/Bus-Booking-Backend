package com.manu.Bus.POJO;

public class Route {
	
	private int routeId;
	private String routeName;
	private String source;
	private String destination;
	private int distance;
	public Route() {
		super();
	}
	public Route(int routeId, String routeName, String source, String destination, int distance) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeName=" + routeName + ", source=" + source + ", destination="
				+ destination + ", distance=" + distance + "]";
	}

}
