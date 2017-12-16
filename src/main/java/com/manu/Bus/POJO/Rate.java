package com.manu.Bus.POJO;

public class Rate {
	private int rateId;
	private String busType;
	private int ratePerKm;
	private int baseRate;
	public Rate() {
		super();
	}
	public Rate(int rateId, String busType, int ratePerKm, int baseRate) {
		super();
		this.rateId = rateId;
		this.busType = busType;
		this.ratePerKm = ratePerKm;
		this.baseRate = baseRate;
	}
	public int getRateId() {
		return rateId;
	}
	public void setRateId(int rateId) {
		this.rateId = rateId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getRatePerKm() {
		return ratePerKm;
	}
	public void setRatePerKm(int ratePerKm) {
		this.ratePerKm = ratePerKm;
	}
	public int getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(int baseRate) {
		this.baseRate = baseRate;
	}
	@Override
	public String toString() {
		return "Rate [rateId=" + rateId + ", busType=" + busType + ", ratePerKm=" + ratePerKm + ", baseRate=" + baseRate
				+ "]";
	}

}
