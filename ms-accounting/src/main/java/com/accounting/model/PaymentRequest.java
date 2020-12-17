package com.accounting.model;

public class PaymentRequest {

	private long orderId;
	private int id;

	public long getOrderId() {
		return orderId;
	}

	public int getId() {
		return id;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PaymentRequest [orderId=" + orderId + ", id=" + id + "]";
	}
}
