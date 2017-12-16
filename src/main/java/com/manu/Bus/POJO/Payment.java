package com.manu.Bus.POJO;

import java.util.Date;

public class Payment {
	private int paymentId;
	private int bookingId;
	private int amount;
	private Date bookingDate;
	public Payment() {
		super();
	}
	public Payment(int paymentId, int bookingId, int amount, Date bookingDate) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.amount = amount;
		this.bookingDate = bookingDate;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
		return "Payment [paymentId=" + paymentId + ", bookingId=" + bookingId + ", amount=" + amount + ", bookingDate="
				+ bookingDate + "]";
	}
	

}
